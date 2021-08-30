package com.example.helloworld

import akka.actor.typed.ActorSystem

import scala.concurrent.Future

class GreeterServiceImpl(system: ActorSystem[_]) extends GreeterService {
  private implicit val sys: ActorSystem[_] = system


  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    Future.successful(HelloReply(s"Здорова, ${request.name}"))
  }


  override def sayPigInfo (request: PigInfoRequest): Future[PigInfoReply] = {
    Future.successful(PigInfoReply(request.id,"Свинка",9200))
  }
  override def sayHumanInfo (request: HumanRequest): Future[HumanReply] = {
    Future.successful(HumanReply(request.id,"Свинка","Дмитрий","Леонидович",23400))
  }
  override def sayWorkInfoHuman (request: WorkInfoHumanRequest): Future[WorkInfoHumanReply] = {
    Future.successful(WorkInfoHumanReply("Свинарник",Some(HumanRequest(1,"Свинка","Дмитрий","Леонидович",23400))))
  }

}