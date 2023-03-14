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
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyQueueException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.EmptyStackException;
import com.humanCloud.SpringBootProjectHumanCloud.HumanCloud.Queue;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/datastructure/queue")
public class QueueController {
	@Autowired
	Queue queue;

	@PostMapping("/enqueue")
	ResponseEntity<?> enqueue(HttpServletRequest request, HttpServletResponse response) {
		queue.enqueue(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("enqueue value is:" + request.getParameter("value"));
	}

	@GetMapping("/display")
	ResponseEntity<?> display(HttpServletRequest request, HttpServletResponse response) throws EmptyQueueException {
		int[] arr = queue.display();
		return ResponseEntity.ok(arr);
	}

	@DeleteMapping("/dequeue")
	ResponseEntity<?> dequeue(HttpServletRequest request, HttpServletResponse response) throws EmptyQueueException {
		int value = queue.dequeue();
		return ResponseEntity.ok("Deleted value is :" + value);
	}

	@ExceptionHandler(EmptyQueueException.class)
	ResponseEntity<?> exception(EmptyQueueException ex) {
		ResponseException exception = new ResponseException(new Date(0), HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}
}