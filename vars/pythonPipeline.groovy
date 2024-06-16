
def call(String dockerImage, String command) {
    sh "docker run --rm -v ${pwd()}:/app -w /app ${dockerImage} python ${command}"
}
