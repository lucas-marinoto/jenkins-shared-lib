// vars/pythonPipeline.groovy

def call(String dockerImage, String scriptName) {
    // Copia o script Python da Shared Library para o workspace do Jenkins
    writeFile file: scriptName, text: libraryResource("scripts/${scriptName}")
    writeFile file: 'log_utils.py', text: libraryResource("scripts/log_utils.py")

    // Executa o script Python dentro do container Docker
    sh "docker run --rm -v ${pwd()}:/app -w /app ${dockerImage} python ${scriptName}"
}