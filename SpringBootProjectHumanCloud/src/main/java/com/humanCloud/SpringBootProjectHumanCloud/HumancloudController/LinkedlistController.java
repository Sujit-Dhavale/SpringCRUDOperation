package com.humanCloud.SpringBootProjectHumanCloud.HumancloudController;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humanCloud.SpringBootProjectHumanCloud.ExceptionHandle.ResponseException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.LinkedList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/datastructure/linkedlist")
public class LinkedlistController {
	@Autowired
	LinkedList ll;

	@PostMapping("/insert")
	ResponseEntity<?> insert(HttpServletRequest request, HttpServletResponse response) {
		ll.insert(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok(" Insert value is :" + request.getParameter("value"));
	}

	@GetMapping("/display")
	ResponseEntity<?> display(HttpServletRequest request, HttpServletResponse response)
			throws EmptyLinkedListException {
		int[] arr = ll.display();
		return ResponseEntity.ok(arr);
	}

	@DeleteMapping("/deletebyindex")
	ResponseEntity<?> deletebyindex(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, EmptyLinkedListException {

		if (request.getParameter("index") == null) {
			ll.delete();
		} else
			ll.delete(Integer.valueOf(request.getParameter("index")));
		return ResponseEntity.ok("Deleted value is successfully.......");

	}

	@ExceptionHandler(EmptyLinkedListException.class)
	ResponseEntity<?> exception(EmptyLinkedListException ex) {
		ResponseException exception = new ResponseException(new Date(0), HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}

}
