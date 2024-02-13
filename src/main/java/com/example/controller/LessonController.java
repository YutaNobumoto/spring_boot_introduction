package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@から始まるものはアノテーションといい、プログラムに特別な処理を追加するもの
@Controller//フームワークがこのクラスをControllerとして認識する
@RequestMapping("/lesson")//ControllerにどんなURLでアクセスするのかの設定

public class LessonController {
	@GetMapping("/sample")//クラスに指定したURL以降のパスの指定
	@ResponseBody//メソッド返り値自体をレスポンスに利用できるようになり、ブラウザは返り値を画面に出力
	public String sample() {
		return "Hello World";
	}
}
