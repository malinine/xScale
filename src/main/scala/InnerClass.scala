package com.innerclass

class Graph{
  class Node {
    var connectedNodes: List[Graph#Node] = Nil
    def connectTo(node: Graph#Node) {
      if(connectedNodes.find(node.equals).isEmpty){
        connectedNodes = node :: connectedNodes
      }
    }
  }
  var nodes: List[Node] = Nil
  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }

}

//** if we have two graphs,the type system of Scala does not allow us to mix nodes
//** defined within one graph with the nodes of another graph,since the nodes of the other graph
//** have a different type.
object GraphTest extends App {
  val g = new Graph
  val n1: g.Node = g.newNode
  val n2: g.Node = g.newNode
  n1.connectTo(n2)
  val h = new Graph
  val n3: h.Node = h.newNode
  n3.connectTo(n1) // illegal !!
  println(n1)

}

//** Please note that this program doesn’t allow us to attach a node to two different graphs.
//** If we want to remove this restriction as well, we have to change the type of variable nodes
// to Graph#Node.

