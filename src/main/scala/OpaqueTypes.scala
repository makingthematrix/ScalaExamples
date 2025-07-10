object OpaqueTypes:
  opaque type Foo = Int
  val v: Foo = 123 // Inside the scope, no error

//val v: OpaqueTypes.Foo = 123 // Outside - type mismatch




type Bar = OpaqueTypes.Foo