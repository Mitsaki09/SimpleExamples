
// Generated by Akka gRPC. DO NOT EDIT.
package com.example.SwordMasterServiceProto

import akka.annotation.ApiMayChange


trait HumanMasterService {
  
  
  def sayHuman(in: com.example.SwordMasterServiceProto.HumanRequest): scala.concurrent.Future[com.example.SwordMasterServiceProto.HumanReply]
  
}



object HumanMasterService extends akka.grpc.ServiceDescription {
  val name = "HumanMasterService"

  val descriptor: com.google.protobuf.Descriptors.FileDescriptor =
    com.example.SwordMasterServiceProto.SwordProto.javaDescriptor;

  object Serializers {
    import akka.grpc.scaladsl.ScalapbProtobufSerializer
    
    val HumanRequestSerializer = new ScalapbProtobufSerializer(com.example.SwordMasterServiceProto.HumanRequest.messageCompanion)
    
    val HumanReplySerializer = new ScalapbProtobufSerializer(com.example.SwordMasterServiceProto.HumanReply.messageCompanion)
    
  }

  @ApiMayChange
  object MethodDescriptors {
    import akka.grpc.internal.Marshaller
    import io.grpc.MethodDescriptor
    import Serializers._

    
    val sayHumanDescriptor: MethodDescriptor[com.example.SwordMasterServiceProto.HumanRequest, com.example.SwordMasterServiceProto.HumanReply] =
      MethodDescriptor.newBuilder()
        .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
        .setFullMethodName(MethodDescriptor.generateFullMethodName("HumanMasterService", "SayHuman"))
        .setRequestMarshaller(new Marshaller(HumanRequestSerializer))
        .setResponseMarshaller(new Marshaller(HumanReplySerializer))
        .setSampledToLocalTracing(true)
        .build()
    
  }
}
