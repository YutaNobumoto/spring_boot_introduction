package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.SampleForm;

//@から始まるものはアノテーションといい、プログラムに特別な処理を追加するもの
@Controller//フームワークがこのクラスをControllerとして認識する
@RequestMapping("/lesson")//ControllerにどんなURLでアクセスするのかの設定

public class LessonController {
	@GetMapping("/sample")//クラスに指定したURL以降のパスの指定
	//メソッド返り値自体をレスポンスに利用できるようになり、ブラウザは返り値を画面に出力
	//@ResponseBody//(HTMLをレスポンスにする場合@ResponseBodyを必ず削除する
	public String sample() {
		return "Hello World";
	}
	
	@GetMapping("/test")
	//@ResponseBody
	public String test() {
		return "Good Evening";
	}
	
	@GetMapping("/learn/{num}")
	//@ResponseBody
	public String test(@PathVariable Integer num) {
		return "引数の値："+num;
	}
		
	@GetMapping("/view")
	//Model型の値を必ず仮引数にもつ
	public String sample(Model model) {
		//変数定義
		String text="Hello Spring Boot";
		//messageという属性名、Hello Spring Bootという値を追加
		model.addAttribute("message",text);
		return "index";
	}
	
	@GetMapping("/request_test")
	@ResponseBody
	public String getTest(@RequestParam("name") String name, @RequestParam("bloodType") String bloodType) {
		return "名前："+name+"<br>血液型:"+bloodType;
	}
	
	@PostMapping("/request_test")
	@ResponseBody
	public String postTest(SampleForm sampleForm) {
		return "名前："+sampleForm.getName()+"<br>血液型:"+sampleForm.getBloodType();
	}
	
	@GetMapping("/form_test")
	public String formTest(SampleForm sampleForm, Model model) {
		model.addAttribute("sampleForm", sampleForm);
		return "lesson/form_test";
	}
}

