package com.example.helloworld

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.grpc.GrpcClientSettings

import scala.concurrent.ExecutionContext

object GreeterClient extends App {

  // имплиситы нужные для работы фьюч
  implicit val sys: ActorSystem[_] = ActorSystem(Behaviors.empty, "GreeterClient")
  implicit val ec: ExecutionContext = sys.executionContext


  val client = GreeterServiceClient(GrpcClientSettings.fromConfig("helloworld.GreeterService"))

  val helloRequest = HelloRequest("Rodion")
  val reply = client.sayHello(helloRequest)

  reply
    .map(res => println("Успех =>" + res))
    .recover(exception => println(s"Не успех => $exception"))



  val pigInfoRequest = PigInfoRequest(1)
  val reply2 = client.sayPigInfo(pigInfoRequest)

  reply2
    .map(res => println("Успех =>" + res))
    .recover(exception => println(s"Не успех => $exception"))


  val humanRequest = HumanRequest(1)
  val reply3 = client.sayHumanInfo(humanRequest)

  reply3
    .map(res => println("Успех =>" + res))
    .recover(exception => println(s"Не успех => $exception"))



  val workInfoHumanRequest = WorkInfoHumanRequest("",Some(humanRequest))
  val reply4 = client.sayWorkInfoHuman(workInfoHumanRequest)

  reply4
    .map(res => println("Успех =>" + res))
    .recover(exception => println(s"Не успех => $exception"))






}