// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.example.SwordMasterServiceProto

@SerialVersionUID(0L)
final case class Outer(
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Outer] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
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
      unknownFields.writeTo(_output__)
    }
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = throw new MatchError(__fieldNumber)
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = throw new MatchError(__field)
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.example.SwordMasterServiceProto.Outer
    // @@protoc_insertion_point(GeneratedMessage[Outer])
}

object Outer extends scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Outer] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Outer] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.SwordMasterServiceProto.Outer = {
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.example.SwordMasterServiceProto.Outer(
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.SwordMasterServiceProto.Outer] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.example.SwordMasterServiceProto.Outer(
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = SwordProto.javaDescriptor.getMessageTypes().get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = SwordProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      _root_.com.example.SwordMasterServiceProto.Outer.MiddleAA
    )
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.example.SwordMasterServiceProto.Outer(
  )
  /** Level 1
    */
  @SerialVersionUID(0L)
  final case class MiddleAA(
      unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
      ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[MiddleAA] {
      @transient
      private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
      private[this] def __computeSerializedValue(): _root_.scala.Int = {
        var __size = 0
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
        unknownFields.writeTo(_output__)
      }
      def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
      def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
      def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = throw new MatchError(__fieldNumber)
      def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = throw new MatchError(__field)
      def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
      def companion = com.example.SwordMasterServiceProto.Outer.MiddleAA
      // @@protoc_insertion_point(GeneratedMessage[Outer.MiddleAA])
  }
  
  object MiddleAA extends scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Outer.MiddleAA] {
    implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Outer.MiddleAA] = this
    def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.SwordMasterServiceProto.Outer.MiddleAA = {
      var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      com.example.SwordMasterServiceProto.Outer.MiddleAA(
          unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
    implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.SwordMasterServiceProto.Outer.MiddleAA] = _root_.scalapb.descriptors.Reads{
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
        com.example.SwordMasterServiceProto.Outer.MiddleAA(
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = com.example.SwordMasterServiceProto.Outer.javaDescriptor.getNestedTypes().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = com.example.SwordMasterServiceProto.Outer.scalaDescriptor.nestedMessages(0)
    def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
    lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
      Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
        _root_.com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner
      )
    def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
    lazy val defaultInstance = com.example.SwordMasterServiceProto.Outer.MiddleAA(
    )
    /** Level 2
      */
    @SerialVersionUID(0L)
    final case class Inner(
        ival: _root_.scala.Long = 0L,
        booly: _root_.scala.Boolean = false,
        unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
        ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Inner] {
        @transient
        private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
        private[this] def __computeSerializedValue(): _root_.scala.Int = {
          var __size = 0
          
          {
            val __value = ival
            if (__value != 0L) {
              __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(1, __value)
            }
          };
          
          {
            val __value = booly
            if (__value != false) {
              __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(2, __value)
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
            val __v = ival
            if (__v != 0L) {
              _output__.writeInt64(1, __v)
            }
          };
          {
            val __v = booly
            if (__v != false) {
              _output__.writeBool(2, __v)
            }
          };
          unknownFields.writeTo(_output__)
        }
        def withIval(__v: _root_.scala.Long): Inner = copy(ival = __v)
        def withBooly(__v: _root_.scala.Boolean): Inner = copy(booly = __v)
        def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
        def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
        def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
          (__fieldNumber: @_root_.scala.unchecked) match {
            case 1 => {
              val __t = ival
              if (__t != 0L) __t else null
            }
            case 2 => {
              val __t = booly
              if (__t != false) __t else null
            }
          }
        }
        def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
          _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
          (__field.number: @_root_.scala.unchecked) match {
            case 1 => _root_.scalapb.descriptors.PLong(ival)
            case 2 => _root_.scalapb.descriptors.PBoolean(booly)
          }
        }
        def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
        def companion = com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner
        // @@protoc_insertion_point(GeneratedMessage[Outer.MiddleAA.Inner])
    }
    
    object Inner extends scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner] {
      implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner] = this
      def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner = {
        var __ival: _root_.scala.Long = 0L
        var __booly: _root_.scala.Boolean = false
        var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
        var _done__ = false
        while (!_done__) {
          val _tag__ = _input__.readTag()
          _tag__ match {
            case 0 => _done__ = true
            case 8 =>
              __ival = _input__.readInt64()
            case 16 =>
              __booly = _input__.readBool()
            case tag =>
              if (_unknownFields__ == null) {
                _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
              }
              _unknownFields__.parseField(tag, _input__)
          }
        }
        com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner(
            ival = __ival,
            booly = __booly,
            unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
        )
      }
      implicit def messageReads: _root_.scalapb.descriptors.Reads[com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner] = _root_.scalapb.descriptors.Reads{
        case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
          _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
          com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner(
            ival = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
            booly = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Boolean]).getOrElse(false)
          )
        case _ => throw new RuntimeException("Expected PMessage")
      }
      def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = com.example.SwordMasterServiceProto.Outer.MiddleAA.javaDescriptor.getNestedTypes().get(0)
      def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = com.example.SwordMasterServiceProto.Outer.MiddleAA.scalaDescriptor.nestedMessages(0)
      def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
      lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
      def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
      lazy val defaultInstance = com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner(
        ival = 0L,
        booly = false
      )
      implicit class InnerLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner](_l) {
        def ival: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.ival)((c_, f_) => c_.copy(ival = f_))
        def booly: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Boolean] = field(_.booly)((c_, f_) => c_.copy(booly = f_))
      }
      final val IVAL_FIELD_NUMBER = 1
      final val BOOLY_FIELD_NUMBER = 2
      def of(
        ival: _root_.scala.Long,
        booly: _root_.scala.Boolean
      ): _root_.com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner = _root_.com.example.SwordMasterServiceProto.Outer.MiddleAA.Inner(
        ival,
        booly
      )
      // @@protoc_insertion_point(GeneratedMessageCompanion[Outer.MiddleAA.Inner])
    }
    
    implicit class MiddleAALens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.Outer.MiddleAA]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.SwordMasterServiceProto.Outer.MiddleAA](_l) {
    }
    def of(
    ): _root_.com.example.SwordMasterServiceProto.Outer.MiddleAA = _root_.com.example.SwordMasterServiceProto.Outer.MiddleAA(
    )
    // @@protoc_insertion_point(GeneratedMessageCompanion[Outer.MiddleAA])
  }
  
  implicit class OuterLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.example.SwordMasterServiceProto.Outer]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.example.SwordMasterServiceProto.Outer](_l) {
  }
  def of(
  ): _root_.com.example.SwordMasterServiceProto.Outer = _root_.com.example.SwordMasterServiceProto.Outer(
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[Outer])
}
