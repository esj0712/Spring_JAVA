package kr.co.softsoldesk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
// #1
public class TestController {
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for (String str1 : data3) {
			System.out.println("data3 : " + str1);

		}

		return "result";
	}
	// ===============================================================

	// #2
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {

		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		if (data3 != null) {
			for (String str1 : data3) {
				System.out.println("data3 : " + str1);

			}

		}
		return "result";
	}

	// ===============================================================
	// #3
	/*
	 * WebRequest : HttpServletRequest에 확장된 기능으로 요청 정보를 대부분 그대로 가져옴 Servlet API에
	 * 종속되지 않음 즉 서블릿+포틀릿(포털페이지의 날씨정보, 뉴스, 전자우편, 주소)
	 */
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for (String str1 : data3) {
			System.out.println("data3 : " + str1);

		}

		return "result";
	}

	// ===============================================================
	// #4
	// @PathVariable String data1으로 받아야 하지만 형변환이 가능
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1, @PathVariable int data2, @PathVariable int data3) {

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);

		int add = data1 + data2 + data3;
		System.out.println("add : " + add);

		return "result";
	}

	// ===============================================================
	// #5
	// @RequestParam 으로 받으면 파라미터 ㅣ름과 변수이름을 다르게 사용할 수 있음
	@GetMapping("/test5")
	public String test5(@RequestParam(value = "data1") int value1, @RequestParam(value = "data2") int value2,
			@RequestParam(value = "data3") int[] value3) {

		System.out.println("data1 : " + value1);
		System.out.println("data2 : " + value2);

		for (int a1 : value3) {
			System.out.println("data3 : " + a1);
		}

		return "result";
	}

	// ===============================================================
	// #6
	// @RequestParam 으로 받으면 파라미터 ㅣ름과 변수이름을 다르게 사용할 수 있음
	@GetMapping("/test6")
	public String test6(@RequestParam(value = "data1") int value1, @RequestParam(value = "data2") int[] value3) {

		System.out.println("data1 : " + value1);

		for (int a1 : value3) {
			System.out.println("data3 : " + a1);
		}

		return "result";
	}

	// ===============================================================
	// #7
	// @RequestParam 으로 받으면 파라미터 ㅣ름과 변수이름을 다르게 사용할 수 있음
	@GetMapping("/test7")
	public String test7(@RequestParam int data1, @RequestParam int data2, @RequestParam int[] data3) {

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);

		for (int a1 : data3) {
			System.out.println("data3 : " + a1);
		}

		return "result";
	}

	// ===============================================================
	// #8 String => null/ int => 0
	@GetMapping("/test8")
	public String test8(@RequestParam int data1, 
						@RequestParam(required = false) String data2,
						@RequestParam(defaultValue = "0") int data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);

		return "result";
	}

}
