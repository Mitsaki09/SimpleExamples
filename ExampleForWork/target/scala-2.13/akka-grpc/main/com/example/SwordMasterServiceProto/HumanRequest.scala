// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.SwordMasterServiceProto

@SerialVersionUID(0L)
final case class HumanRequest(
    name: _root_.scala.Predef.String = "",
    age: _root_.scala.Int = 0,
    weight: _root_.scala.Int = 0,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[HumanRequest] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = age
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
        }
      };
      
      {
        val __value = weight
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
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
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = age
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      {
        val __v = weight
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withName(__v: _root_.scala.Predef.String): HumanRequest = copy(name = __v)
    def withAge(__v: _root_.scala.Int): HumanRequest = copy(age = __v)
    def withWeight(__v: _root_.scala.Int): HumanRequest = copy(weight = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = age
          if (__t != 0) __t else null
        }
        case 3 => {
          val __t = weight
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(name)
        case 2 => _root_.scalapb.descriptors.PInt(age)
        case 3 => _root_.scalapb.descriptors.PInt(weight)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.SwordMasterServiceProto.HumanRequest
    // @@protoc_insertion_point(GeneratedMessage[HumanRequest])
}

object HumanRequest extends scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.HumanRequest] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.HumanRequest] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.SwordMasterServiceProto.HumanRequest = {
    var __name: _root_.scala.Predef.String = ""
    var __age: _root_.scala.Int = 0
    var __weight: _root_.scala.Int = 0
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __name = _input__.readStringRequireUtf8()
        case 16 =>
          __age = _input__.readInt32()
        case 24 =>
          __weight = _input__.readInt32()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.SwordMasterServiceProto.HumanRequest(
        name = __name,
        age = __age,
        weight = __weight,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.SwordMasterServiceProto.HumanRequest] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.SwordMasterServiceProto.HumanRequest(
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        age = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        weight = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = SwordProto.javaDescriptor.getMessageTypes().get(8)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = SwordProto.scalaDescriptor.messages(8)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.SwordMasterServiceProto.HumanRequest(
    name = "",
    age = 0,
    weight = 0
  )
  implicit class HumanRequestLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.HumanRequest]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.SwordMasterServiceProto.HumanRequest](_l) {
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def age: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.age)((c_, f_) => c_.copy(age = f_))
    def weight: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.weight)((c_, f_) => c_.copy(weight = f_))
  }
  final val NAME_FIELD_NUMBER = 1
  final val AGE_FIELD_NUMBER = 2
  final val WEIGHT_FIELD_NUMBER = 3
  def of(
    name: _root_.scala.Predef.String,
    age: _root_.scala.Int,
    weight: _root_.scala.Int
  ): _root_.com.example.SwordMasterServiceProto.HumanRequest = _root_.com.example.SwordMasterServiceProto.HumanRequest(
    name,
    age,
    weight
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[HumanRequest])
}
