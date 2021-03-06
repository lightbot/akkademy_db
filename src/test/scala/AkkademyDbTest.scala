package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.akkademy.messages.SetRequest
import org.scalatest.{FunSpecLike, Matchers}
import scala.concurrent.duration._

class AkkademyDbSpec extends FunSpecLike with Matchers {
    implicit val system = ActorSystem()
    implicit val timeout = Timeout(5 seconds)

    describe("akkademyDb") {
        describe("given SetRequest") {
            it ("should placeg key/value into map") {
                val actorRef = TestActorRef(new AkkademyDb)
                actorRef ! SetRequest("key", "value")
                actorRef ! SetRequest("int", new Integer(10))
                actorRef ! SetRequest("key", "another value")

                val akkademyDb = actorRef.underlyingActor
                akkademyDb.map.get("key") should equal (Some("another value"))
                akkademyDb.map.get("int") should equal (Some(10))
            }
        }
    }
}

