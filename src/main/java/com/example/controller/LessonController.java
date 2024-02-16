package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
