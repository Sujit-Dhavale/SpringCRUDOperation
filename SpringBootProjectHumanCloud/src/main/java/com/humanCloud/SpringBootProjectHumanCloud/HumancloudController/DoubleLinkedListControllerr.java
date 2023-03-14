package com.humanCloud.SpringBootProjectHumanCloud.HumancloudController;

import java.net.http.HttpResponse;
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
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedList;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.DoubleLinkedListException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/datastructure/doublelinkedlist")

public class DoubleLinkedListControllerr {

	@Autowired
	DoubleLinkedList dl;

	@PostMapping("/addtoend")
	ResponseEntity<?> addtoend(HttpServletRequest request, HttpServletResponse response) {
		int val = dl.addtoend(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("value is added Successfully ");
	}

	@PostMapping("/addtobegin")
	ResponseEntity<?> addtobegin(HttpServletRequest request, HttpServletResponse response) {
		int val = dl.addtobegin(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("value is added successfully");
	}

	@GetMapping("/display")
	ResponseEntity<?> display(HttpServletRequest request, HttpServletResponse response)
			throws DoubleLinkedListException {
		int[] arr = dl.displayForward();
		return ResponseEntity.ok(arr);
	}

	@DeleteMapping("/deletedbyindex")
	ResponseEntity<?> deletedbyindex(HttpServletRequest request, HttpServletResponse response)
			throws DoubleLinkedListException {
		if (request.getParameter("index") == null) {
			dl.delete();
		} else
			dl.deleteForward(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("value is deleted successfully......");
	}

	@ExceptionHandler(DoubleLinkedListException.class)
	ResponseEntity<?> exception(DoubleLinkedListException ex) {
		ResponseException exception = new ResponseException(new Date(0), HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}
}
