// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.SwordMasterServiceProto

@SerialVersionUID(0L)
final case class Wheel(
    radius: _root_.scala.Long = 0L,
    price: _root_.scala.Long = 0L,
    brand: _root_.scala.Predef.String = "",
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Wheel] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = radius
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(1, __value)
        }
      };
      
      {
        val __value = price
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(2, __value)
        }
      };
      
      {
        val __value = brand
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
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
        val __v = radius
        if (__v != 0L) {
          _output__.writeInt64(1, __v)
        }
      };
      {
        val __v = price
        if (__v != 0L) {
          _output__.writeInt64(2, __v)
        }
      };
      {
        val __v = brand
        if (!__v.isEmpty) {
          _output__.writeString(3, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withRadius(__v: _root_.scala.Long): Wheel = copy(radius = __v)
    def withPrice(__v: _root_.scala.Long): Wheel = copy(price = __v)
    def withBrand(__v: _root_.scala.Predef.String): Wheel = copy(brand = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = radius
          if (__t != 0L) __t else null
        }
        case 2 => {
          val __t = price
          if (__t != 0L) __t else null
        }
        case 3 => {
          val __t = brand
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PLong(radius)
        case 2 => _root_.scalapb.descriptors.PLong(price)
        case 3 => _root_.scalapb.descriptors.PString(brand)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.SwordMasterServiceProto.Wheel
    // @@protoc_insertion_point(GeneratedMessage[Wheel])
}

object Wheel extends scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Wheel] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Wheel] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.SwordMasterServiceProto.Wheel = {
    var __radius: _root_.scala.Long = 0L
    var __price: _root_.scala.Long = 0L
    var __brand: _root_.scala.Predef.String = ""
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __radius = _input__.readInt64()
        case 16 =>
          __price = _input__.readInt64()
        case 26 =>
          __brand = _input__.readStringRequireUtf8()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.SwordMasterServiceProto.Wheel(
        radius = __radius,
        price = __price,
        brand = __brand,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.SwordMasterServiceProto.Wheel] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.SwordMasterServiceProto.Wheel(
        radius = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        price = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        brand = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = SwordProto.javaDescriptor.getMessageTypes().get(6)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = SwordProto.scalaDescriptor.messages(6)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.SwordMasterServiceProto.Wheel(
    radius = 0L,
    price = 0L,
    brand = ""
  )
  implicit class WheelLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.Wheel]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.SwordMasterServiceProto.Wheel](_l) {
    def radius: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.radius)((c_, f_) => c_.copy(radius = f_))
    def price: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.price)((c_, f_) => c_.copy(price = f_))
    def brand: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.brand)((c_, f_) => c_.copy(brand = f_))
  }
  final val RADIUS_FIELD_NUMBER = 1
  final val PRICE_FIELD_NUMBER = 2
  final val BRAND_FIELD_NUMBER = 3
  def of(
    radius: _root_.scala.Long,
    price: _root_.scala.Long,
    brand: _root_.scala.Predef.String
  ): _root_.com.example.SwordMasterServiceProto.Wheel = _root_.com.example.SwordMasterServiceProto.Wheel(
    radius,
    price,
    brand
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[Wheel])
}