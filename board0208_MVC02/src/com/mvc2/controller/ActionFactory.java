package com.mvc2.controller;

import com.mvc2.controller.action.Action;
import com.mvc2.controller.action.ListAction;
import com.mvc2.controller.action.LoginAction;
import com.mvc2.controller.action.LoginBtnAction;
import com.mvc2.controller.action.LogoutAction;
import com.mvc2.controller.action.WritePageAction;
import com.mvc2.controller.action.WriteBtnAction;

public class ActionFactory {

	private ActionFactory() {
		
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("list")) {
			action = new ListAction();
		} else if(command.equals("login")) {
			action = new LoginAction();
		} else if(command.equals("loginBtn")) {
			action = new LoginBtnAction();
		} else if(command.equals("logout")) {
			action = new LogoutAction();
		} else if(command.equals("writePage")) {
			action = new WritePageAction();
		} else if(command.equals("writeSaveBtn")) {
			action = new WriteBtnAction();
		}
		
		return action;
	}
	
	
	
}
