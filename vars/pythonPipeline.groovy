// vars/pythonPipeline.groovy

def call(String dockerImage, String scriptName) {
    // Copia o script Python da Shared Library para o workspace do Jenkins
    writeFile file: scriptName, text: libraryResource("scripts/${scriptName}")
    sh "cat ${scriptName}"

    // Executa o script Python dentro do container Docker
    sh "docker run --rm -v ${pwd()}:/app -w /app ${dockerImage} python ${scriptName}"
}