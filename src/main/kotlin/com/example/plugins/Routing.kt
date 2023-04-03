package com.example.plugins

import com.example.plugins.model.Employee
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
//import io.ktor.server.plugins.contentnegotiation.ContentNegotiation as ServerContentNegotiation

fun Application.configureRouting() {

    install(ContentNegotiation) {
        json()
    }

    val employees = mutableListOf<Employee>()

    routing {
        get("/") {
            call.respondText("Kya haal hai?")
        }
        get("/employee") {
            call.respond(employees)
        }

        post("/employee") {
            print("data received\n")
            val requestBody = call.receive<Employee>()
            employees.add(requestBody)
            call.respond(requestBody)
        }
    }
}
