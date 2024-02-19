package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class SessionController {
	//HttpSession型のフィールドを定義
	private HttpSession session;
	
	@Autowired//引数に紐づくクラスのインスタンスを生成し、利用することができる
	public SessionController(HttpSession session) {
		//フィールドに代入
		this.session=session;
	}
	
	//sessionへの保存処理（基本POSTで行うが今回はGET）
	@GetMapping("/set")
	@ResponseBody
	public String set(@RequestParam("name") String name, @RequestParam("bloodType") String bloodType) {
		this.session.setAttribute("name", name);
		this.session.setAttribute("bloodType", bloodType);
		return "保存しました";
	}
	
	//sessionの値の取得
	@GetMapping("/get")
	@ResponseBody
	public String get() {
		String name=(String) this.session.getAttribute("name");
		String bloodType=(String) this.session.getAttribute("bloodType");
		if(name==null) {
			name="名無し";
		}
		if(bloodType==null) {
			bloodType="不明";
		}
		return "名前："+name+"<br>血液型："+bloodType;
	}
	
	//sessionの値の削除
	@GetMapping("/delete")
	@ResponseBody
	public String delete() {
		session.removeAttribute("name");
		session.removeAttribute("bloodType");
		return "削除しました";
	}
}
