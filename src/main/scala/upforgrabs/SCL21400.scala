package upforgrabs

// Highlight missing enum constructor arguments without "extends"
// https://youtrack.jetbrains.com/issue/SCL-21400/Highlight-missing-enum-constructor-arguments-without-extends

object SCL21400 {
/*
  class Color1 (y: Int) {
    //class Green extends Color1 // unspecified value parameters: y: Int -- this is expected
  }

  enum Color2 (y: Int) {
    case Red extends Color2(1)
   // case Green extends Color2 // unspecified value parameters: y: Int -- this is expected
  }
*/

  enum Color3 (y: Int) {
    case Red extends Color3(1)
    //case Green extends Color3
    //
     //case Green
    // !!! missing argument for parameter y of constructor Color -- bad code is green
  }
}
