def call(){
    sh "docker run -d --name zomato1 -p 3000:3000 claw4321/zomato:latest"
}