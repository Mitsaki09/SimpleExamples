// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.helloworld

@SerialVersionUID(0L)
final case class House(
    citizen1: _root_.scala.Option[com.example.helloworld.Citizen] = _root_.scala.None,
    citizen2: _root_.scala.Option[com.example.helloworld.Citizen] = _root_.scala.None,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[House] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      if (citizen1.isDefined) {
        val __value = citizen1.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (citizen2.isDefined) {
        val __value = citizen2.get
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
      citizen1.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      citizen2.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def getCitizen1: com.example.helloworld.Citizen = citizen1.getOrElse(com.example.helloworld.Citizen.defaultInstance)
    def clearCitizen1: House = copy(citizen1 = _root_.scala.None)
    def withCitizen1(__v: com.example.helloworld.Citizen): House = copy(citizen1 = Option(__v))
    def getCitizen2: com.example.helloworld.Citizen = citizen2.getOrElse(com.example.helloworld.Citizen.defaultInstance)
    def clearCitizen2: House = copy(citizen2 = _root_.scala.None)
    def withCitizen2(__v: com.example.helloworld.Citizen): House = copy(citizen2 = Option(__v))
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => citizen1.orNull
        case 2 => citizen2.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => citizen1.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => citizen2.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.helloworld.House
    // @@protoc_insertion_point(GeneratedMessage[House])
}

object House extends scalapb.GeneratedMessageCompanion[com.example.helloworld.House] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.helloworld.House] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.helloworld.House = {
    var __citizen1: _root_.scala.Option[com.example.helloworld.Citizen] = _root_.scala.None
    var __citizen2: _root_.scala.Option[com.example.helloworld.Citizen] = _root_.scala.None
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __citizen1 = Option(__citizen1.fold(_root_.scalapb.LiteParser.readMessage[com.example.helloworld.Citizen](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 18 =>
          __citizen2 = Option(__citizen2.fold(_root_.scalapb.LiteParser.readMessage[com.example.helloworld.Citizen](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.helloworld.House(
        citizen1 = __citizen1,
        citizen2 = __citizen2,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.helloworld.House] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.helloworld.House(
        citizen1 = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[com.example.helloworld.Citizen]]),
        citizen2 = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[com.example.helloworld.Citizen]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = HelloworldProto.javaDescriptor.getMessageTypes().get(9)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = HelloworldProto.scalaDescriptor.messages(9)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = com.example.helloworld.Citizen
      case 2 => __out = com.example.helloworld.Citizen
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.helloworld.House(
    citizen1 = _root_.scala.None,
    citizen2 = _root_.scala.None
  )
  implicit class HouseLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.helloworld.House]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.helloworld.House](_l) {
    def citizen1: _root_.scalapb.lenses.Lens[UpperPB, com.example.helloworld.Citizen] = field(_.getCitizen1)((c_, f_) => c_.copy(citizen1 = Option(f_)))
    def optionalCitizen1: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[com.example.helloworld.Citizen]] = field(_.citizen1)((c_, f_) => c_.copy(citizen1 = f_))
    def citizen2: _root_.scalapb.lenses.Lens[UpperPB, com.example.helloworld.Citizen] = field(_.getCitizen2)((c_, f_) => c_.copy(citizen2 = Option(f_)))
    def optionalCitizen2: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[com.example.helloworld.Citizen]] = field(_.citizen2)((c_, f_) => c_.copy(citizen2 = f_))
  }
  final val CITIZEN1_FIELD_NUMBER = 1
  final val CITIZEN2_FIELD_NUMBER = 2
  def of(
    citizen1: _root_.scala.Option[com.example.helloworld.Citizen],
    citizen2: _root_.scala.Option[com.example.helloworld.Citizen]
  ): _root_.com.example.helloworld.House = _root_.com.example.helloworld.House(
    citizen1,
    citizen2
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[House])
}