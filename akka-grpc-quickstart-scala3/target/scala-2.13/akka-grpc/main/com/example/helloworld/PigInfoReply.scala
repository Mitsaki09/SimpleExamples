// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.helloworld

@SerialVersionUID(0L)
final case class PigInfoReply(
    id: _root_.scala.Long = 0L,
    name: _root_.scala.Predef.String = "",
    weight: _root_.scala.Long = 0L,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[PigInfoReply] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = id
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(1, __value)
        }
      };
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = weight
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
        }
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
        val __v = id
        if (__v != 0L) {
          _output__.writeInt64(1, __v)
        }
      };
      {
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = weight
        if (__v != 0L) {
          _output__.writeInt64(3, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withId(__v: _root_.scala.Long): PigInfoReply = copy(id = __v)
    def withName(__v: _root_.scala.Predef.String): PigInfoReply = copy(name = __v)
    def withWeight(__v: _root_.scala.Long): PigInfoReply = copy(weight = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = id
          if (__t != 0L) __t else null
        }
        case 2 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = weight
          if (__t != 0L) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PLong(id)
        case 2 => _root_.scalapb.descriptors.PString(name)
        case 3 => _root_.scalapb.descriptors.PLong(weight)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.helloworld.PigInfoReply
    // @@protoc_insertion_point(GeneratedMessage[PigInfoReply])
}

object PigInfoReply extends scalapb.GeneratedMessageCompanion[com.example.helloworld.PigInfoReply] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.helloworld.PigInfoReply] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.helloworld.PigInfoReply = {
    var __id: _root_.scala.Long = 0L
    var __name: _root_.scala.Predef.String = ""
    var __weight: _root_.scala.Long = 0L
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __id = _input__.readInt64()
        case 18 =>
          __name = _input__.readStringRequireUtf8()
        case 24 =>
          __weight = _input__.readInt64()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.helloworld.PigInfoReply(
        id = __id,
        name = __name,
        weight = __weight,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.helloworld.PigInfoReply] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.helloworld.PigInfoReply(
        id = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        weight = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = HelloworldProto.javaDescriptor.getMessageTypes().get(3)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = HelloworldProto.scalaDescriptor.messages(3)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.helloworld.PigInfoReply(
    id = 0L,
    name = "",
    weight = 0L
  )
  implicit class PigInfoReplyLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.helloworld.PigInfoReply]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.helloworld.PigInfoReply](_l) {
    def id: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.id)((c_, f_) => c_.copy(id = f_))
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def weight: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.weight)((c_, f_) => c_.copy(weight = f_))
  }
  final val ID_FIELD_NUMBER = 1
  final val NAME_FIELD_NUMBER = 2
  final val WEIGHT_FIELD_NUMBER = 3
  def of(
    id: _root_.scala.Long,
    name: _root_.scala.Predef.String,
    weight: _root_.scala.Long
  ): _root_.com.example.helloworld.PigInfoReply = _root_.com.example.helloworld.PigInfoReply(
    id,
    name,
    weight
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[PigInfoReply])
}