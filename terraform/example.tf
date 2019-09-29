provider "aws" {
  profile    = "default"
  region     = "us-east-2"
}

resource "aws_instance" "example" {
  ami           = "ami-cc7551a9"
  instance_type = "t2.micro"
}