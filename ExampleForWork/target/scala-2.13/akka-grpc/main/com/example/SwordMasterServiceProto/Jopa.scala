// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.SwordMasterServiceProto

@SerialVersionUID(0L)
final case class Jopa(
    kakashka: _root_.scala.Option[com.example.SwordMasterServiceProto.Kakashka] = _root_.scala.None,
    color: _root_.scala.Predef.String = "",
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Jopa] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      if (kakashka.isDefined) {
        val __value = kakashka.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      
      {
        val __value = color
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
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
      kakashka.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      {
        val __v = color
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def getKakashka: com.example.SwordMasterServiceProto.Kakashka = kakashka.getOrElse(com.example.SwordMasterServiceProto.Kakashka.defaultInstance)
    def clearKakashka: Jopa = copy(kakashka = _root_.scala.None)
    def withKakashka(__v: com.example.SwordMasterServiceProto.Kakashka): Jopa = copy(kakashka = Option(__v))
    def withColor(__v: _root_.scala.Predef.String): Jopa = copy(color = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => kakashka.orNull
        case 2 => {
          val __t = color
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => kakashka.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => _root_.scalapb.descriptors.PString(color)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.SwordMasterServiceProto.Jopa
    // @@protoc_insertion_point(GeneratedMessage[Jopa])
}

object Jopa extends scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Jopa] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Jopa] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.SwordMasterServiceProto.Jopa = {
    var __kakashka: _root_.scala.Option[com.example.SwordMasterServiceProto.Kakashka] = _root_.scala.None
    var __color: _root_.scala.Predef.String = ""
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __kakashka = Option(__kakashka.fold(_root_.scalapb.LiteParser.readMessage[com.example.SwordMasterServiceProto.Kakashka](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 18 =>
          __color = _input__.readStringRequireUtf8()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.SwordMasterServiceProto.Jopa(
        kakashka = __kakashka,
        color = __color,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.SwordMasterServiceProto.Jopa] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.SwordMasterServiceProto.Jopa(
        kakashka = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[com.example.SwordMasterServiceProto.Kakashka]]),
        color = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = SwordProto.javaDescriptor.getMessageTypes().get(4)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = SwordProto.scalaDescriptor.messages(4)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = com.example.SwordMasterServiceProto.Kakashka
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.SwordMasterServiceProto.Jopa(
    kakashka = _root_.scala.None,
    color = ""
  )
  implicit class JopaLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.Jopa]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.SwordMasterServiceProto.Jopa](_l) {
    def kakashka: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.Kakashka] = field(_.getKakashka)((c_, f_) => c_.copy(kakashka = Option(f_)))
    def optionalKakashka: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[com.example.SwordMasterServiceProto.Kakashka]] = field(_.kakashka)((c_, f_) => c_.copy(kakashka = f_))
    def color: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.color)((c_, f_) => c_.copy(color = f_))
  }
  final val KAKASHKA_FIELD_NUMBER = 1
  final val COLOR_FIELD_NUMBER = 2
  def of(
    kakashka: _root_.scala.Option[com.example.SwordMasterServiceProto.Kakashka],
    color: _root_.scala.Predef.String
  ): _root_.com.example.SwordMasterServiceProto.Jopa = _root_.com.example.SwordMasterServiceProto.Jopa(
    kakashka,
    color
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[Jopa])
}
