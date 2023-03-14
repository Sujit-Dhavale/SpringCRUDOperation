package com.humanCloud.SpringBootProjectHumanCloud.HumancloudController;

import java.sql.Date;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.humanCloud.SpringBootProjectHumanCloud.ExceptionHandle.ResponseException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Stack;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/datastructure/stack")
public class StackController {
	@Autowired
	Stack stk;

	@PostMapping("/push")
	ResponseEntity<?> push(HttpServletRequest request, HttpServletResponse response) {
		stk.push(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("push value :" + request.getParameter("value"));
	}

	@GetMapping("/peek")
	ResponseEntity<?> peek(HttpServletRequest request, HttpServletResponse response) throws EmptyStackException {
		int peek = stk.peek();
		return ResponseEntity.ok(peek);
	}

	@DeleteMapping("/pop")
	ResponseEntity<?> pop(HttpServletRequest request, HttpServletResponse response) throws EmptyStackException {
		int pop = stk.pop();
		return ResponseEntity.ok(pop);
	}

	@GetMapping("/display")
	ResponseEntity<?> display(HttpServletRequest request, HttpServletResponse response) {
		int[] arr = stk.display();
		return ResponseEntity.ok(arr);
	}

	@ExceptionHandler(EmptyStackException.class)
	ResponseEntity<?> exception(EmptyStackException ex) {
		ResponseException exception = new ResponseException(new Date(0), HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}
}
