package tarbi

import predef._

type Nat      = Byte
type Port     = Byte
type Nodes[N] = Set[N]
case class Names[N](inner: Set[N], outer: Set[N])
implicit class InnerNames[N](underlying: Names[N]) 

type Place[N] = (Nat, Nodes[N], Nat)
type Point[N] = (Port, Set[N])
