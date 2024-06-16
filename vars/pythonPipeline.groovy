// // vars/pythonPipeline.groovy

// def call(String dockerImage, String scriptName) {
//     // Copia o script Python da Shared Library para o workspace do Jenkins
//     writeFile file: scriptName, text: libraryResource("scripts/${scriptName}")
//     writeFile file: 'log_utils.py', text: libraryResource("scripts/log_utils.py")

//     // Executa o script Python dentro do container Docker
//     sh "docker run --rm -v ${pwd()}:/app -w /app ${dockerImage} python ${scriptName}"
// }

import org.jenkins.utils.LogUtils
import org.jenkins.utils.BranchUtils

def call(String dockerImage, String scriptName) {
    def sourceBranch = env.gitlabSourceBranch
    def targetBranch = env.gitlabTargetBranch

    println "Running pipeline for pull request from ${sourceBranch} to ${targetBranch}"

    // Verifica se o pull request é válido
    if (!BranchUtils.isValidPullRequest(sourceBranch, targetBranch)) {
        LogUtils.error(this, "Invalid pull request: ${sourceBranch} to ${targetBranch}")
        currentBuild.result = 'FAILURE'
        error("Build failed due to invalid pull request.")
        return
    }
    else{
        LogUtils.success(this, "Valid pull request: ${sourceBranch} to ${targetBranch}")
    }

    def scriptsDir = 'scripts'
    def workspaceDir = pwd()

    // Cria o diretório de scripts no workspace
    sh "mkdir -p ${workspaceDir}/${scriptsDir}"

    // Lista dos scripts a serem copiados
    def scriptFiles = ['example.py', 'log_utils.py']  // Adicione mais scripts conforme necessário

    // Copia todos os scripts Python da Shared Library para o workspace do Jenkins
    scriptFiles.each { script ->
        writeFile file: "${workspaceDir}/${scriptsDir}/${script}", text: libraryResource("scripts/${script}")
    }

    // Executa o script Python dentro do container Docker, montando o diretório de scripts como volume
    def result = sh script: "docker run --rm -v ${workspaceDir}/${scriptsDir}:/app -w /app ${dockerImage} python ${scriptName}", returnStatus: true

    // Verifica o status de saída e exibe a mensagem apropriada
    if (result != 0) {
        LogUtils.error(this, "Python script failed with status: ${result}")
        currentBuild.result = 'FAILURE'
        error("Build failed due to errors in the Python script.")
    } else {
        LogUtils.success(this, "Python script executed successfully.")
    }
}