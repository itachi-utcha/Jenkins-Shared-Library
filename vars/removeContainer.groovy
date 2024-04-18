def call(){
    sh 'docker stop zomato1'
    sh 'docker rm zomato1'
}