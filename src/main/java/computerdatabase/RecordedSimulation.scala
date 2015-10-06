package ems

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://172.27.59.144:9902")
		.inferHtmlResources()



    val uri1 = "http://172.27.59.144:9902/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/list"))
		.pause(4)
		.exec(http("request_1")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/add.jsp"))
		.pause(18)
		.exec(http("request_2")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/home.jsp"))
		.pause(1)
		.exec(http("request_3")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/list"))
		.pause(5)
		.exec(http("request_4")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/edit/103"))
		.pause(30)
		.exec(http("request_5")
			.post("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/edit/update")
			.formParam("code", "103")
			.formParam("name", "harsh")
			.formParam("city", "chandigarh"))
		.pause(4)
		.exec(http("request_6")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/home.jsp"))
		.pause(13)
		.exec(http("request_7")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/list"))
		.pause(12)
		.exec(http("request_8")
			.get("/EmployeeManagementSystem-0.0.1-SNAPSHOT/jsp/home.jsp"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}