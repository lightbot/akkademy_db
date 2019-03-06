package com.akkademy

import akka.actor.Actor
import akka.event.Logging

import scala.collection.mutable.HashMap
import com.akkademy.messages.SetRequest

import scala.collection.mutable

class AkkademyDb extends Actor {
    val map = new mutable.HashMap[String, Object]()
    val log = Logging(context.system, this)

    override def receive: Receive = {
        case SetRequest(key, value) => {
            log.info("received SetRequest - key: {} value: {}", key, value)
            map.put(key, value)
        }
        case e => log.info("received unknown message: {}", e)
    }
}
