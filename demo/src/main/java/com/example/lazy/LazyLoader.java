package com.example.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Lazy
public class LazyLoader {

	public String lazyLoader() {
		return "from lazy loader";
	}
}
