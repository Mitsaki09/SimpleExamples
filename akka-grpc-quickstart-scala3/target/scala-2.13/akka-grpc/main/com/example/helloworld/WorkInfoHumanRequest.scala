// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.helloworld

@SerialVersionUID(0L)
final case class WorkInfoHumanRequest(
    position: _root_.scala.Predef.String = "",
    humanRequest: _root_.scala.Option[com.example.helloworld.HumanRequest] = _root_.scala.None,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[WorkInfoHumanRequest] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = position
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      if (humanRequest.isDefined) {
        val __value = humanRequest.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = position
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      humanRequest.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def withPosition(__v: _root_.scala.Predef.String): WorkInfoHumanRequest = copy(position = __v)
    def getHumanRequest: com.example.helloworld.HumanRequest = humanRequest.getOrElse(com.example.helloworld.HumanRequest.defaultInstance)
    def clearHumanRequest: WorkInfoHumanRequest = copy(humanRequest = _root_.scala.None)
    def withHumanRequest(__v: com.example.helloworld.HumanRequest): WorkInfoHumanRequest = copy(humanRequest = Option(__v))
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = position
          if (__t != "") __t else null
        }
        case 2 => humanRequest.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(position)
        case 2 => humanRequest.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.helloworld.WorkInfoHumanRequest
    // @@protoc_insertion_point(GeneratedMessage[WorkInfoHumanRequest])
}

object WorkInfoHumanRequest extends scalapb.GeneratedMessageCompanion[com.example.helloworld.WorkInfoHumanRequest] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.helloworld.WorkInfoHumanRequest] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.helloworld.WorkInfoHumanRequest = {
    var __position: _root_.scala.Predef.String = ""
    var __humanRequest: _root_.scala.Option[com.example.helloworld.HumanRequest] = _root_.scala.None
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __position = _input__.readStringRequireUtf8()
        case 18 =>
          __humanRequest = Option(__humanRequest.fold(_root_.scalapb.LiteParser.readMessage[com.example.helloworld.HumanRequest](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.helloworld.WorkInfoHumanRequest(
        position = __position,
        humanRequest = __humanRequest,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.helloworld.WorkInfoHumanRequest] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.helloworld.WorkInfoHumanRequest(
        position = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        humanRequest = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[com.example.helloworld.HumanRequest]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = HelloworldProto.javaDescriptor.getMessageTypes().get(6)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = HelloworldProto.scalaDescriptor.messages(6)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 2 => __out = com.example.helloworld.HumanRequest
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.helloworld.WorkInfoHumanRequest(
    position = "",
    humanRequest = _root_.scala.None
  )
  implicit class WorkInfoHumanRequestLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.helloworld.WorkInfoHumanRequest]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.helloworld.WorkInfoHumanRequest](_l) {
    def position: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.position)((c_, f_) => c_.copy(position = f_))
    def humanRequest: _root_.scalapb.lenses.Lens[UpperPB, com.example.helloworld.HumanRequest] = field(_.getHumanRequest)((c_, f_) => c_.copy(humanRequest = Option(f_)))
    def optionalHumanRequest: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[com.example.helloworld.HumanRequest]] = field(_.humanRequest)((c_, f_) => c_.copy(humanRequest = f_))
  }
  final val POSITION_FIELD_NUMBER = 1
  final val HUMANREQUEST_FIELD_NUMBER = 2
  def of(
    position: _root_.scala.Predef.String,
    humanRequest: _root_.scala.Option[com.example.helloworld.HumanRequest]
  ): _root_.com.example.helloworld.WorkInfoHumanRequest = _root_.com.example.helloworld.WorkInfoHumanRequest(
    position,
    humanRequest
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[WorkInfoHumanRequest])
}