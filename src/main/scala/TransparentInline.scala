object TransparentInline:
  class One:
    def one = 1
  
  class Two:
    def two = 2
  
  transparent inline def method(p: Int): Any =
    if p == 1 then One() else  Two()

  val one = method(1)


