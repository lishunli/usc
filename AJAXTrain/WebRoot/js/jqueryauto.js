//表示当前高亮的节点
var highlightindex = -1;
var timeOutId;
$(document)
		.ready( function() {
			// 自动补全框最开始一个个隐藏起来
				var wordInput = $("#word");
				var wordInputOffset = wordInput.offset();
				$("#auto").hide().css("border", "1.5px solid black").css(
						"position", "absolute").css("z-index", "99").css("top",
						wordInputOffset.top + wordInput.height() + 5 + "px")
						.css("left", wordInputOffset.left + "px").width(
								wordInput.width() + 2);
				;
				// 给文本框添加键盘按下并弹出的事件
				$("#word")
						.keyup( function(event) {
							// 处文本框中的键盘事件
								var myEvent = event || window.event();
								var keyCode = myEvent.keyCode;
								if (keyCode >= 65 && keyCode <= 90
										|| keyCode == 8 || keyCode == 46) {
									// 1.首先获取文本框中的内容
									var wordText = wordInput.val();
									var autoNode = $("#auto");
									if (wordText != "") {
										// 2.将文本框中的内容发送服务器端
										clearTimeout(timeOutId);
										timeOutId = setTimeout(
												function() {
													$
															.post(
																	"AutoComplete",
																	{
																		word :wordText
																	},
																	function(
																			data) {
																		// 3.将dom对象data转化成JQuery的对象
																		var jqueryObj = $(data);
																		// 4.找到所有的word节点
																		var wordNodes = jqueryObj
																				.find("word");
																		// 5.遍历所有的word节点新建div节点，并添加到div父节点中

																		// 清空原先的div内容
																		autoNode
																				.html("");
																		wordNodes
																				.each( function(
																						i) {
																					// 获取单词内容
																					var wordNode = $(this);
																					// 新建div节点，并把内容添加到新建的节点中
																					var newDivNode = $(
																							"<div>")
																							.attr(
																									"id",
																									i);
																					// 将新建的节点加入到弹出框的节点中
																					newDivNode
																							.html(
																									wordNode
																											.text())
																							.appendTo(
																									autoNode);
																					newDivNode
																							.mouseover( function() {
																								if (highlightindex != -1) {
																									$(
																											"#auto")
																											.children(
																													"div")
																											.eq(
																													highlightindex)
																											.css(
																													"background-color",
																													"white");
																								}
																								highlightindex = $(
																										this)
																										.attr(
																												"id");
																								$(
																										this)
																										.css(
																												"background-color",
																												"red");
																							});
																					newDivNode
																							.mouseout( function() {
																								$(
																										this)
																										.css(
																												"background-color",
																												"white");
																							});
																					// 增加鼠标的点击事件
																					newDivNode
																							.click( function() {
																								// 取出高亮节点的文本内容
																								var comText = $(
																										this)
																										.text();
																								$(
																										"#auto")
																										.hide();
																								highlightindex = -1;
																								// 文本框中的内容变成高亮节点的内容
																								$(
																										"#word")
																										.val(
																												comText);

																							});

																				});
																		// 显示div，如果服务器端由数据库返回
																		if (wordNodes.length > 0) {
																			autoNode
																					.show();
																		} else {
																			autoNode
																					.hide();
																			highlightindex = -1;
																		}
																	}, "xml");

												}, 500);

									} else {
										autoNode.hide();
										highlightindex = -1;
									}
								} else if (keyCode == 38 || keyCode == 40) {
									// 如果输入的是向上向下按键
									if (keyCode == 38) {
										// 向上
										var autoNodes = $("#auto").children(
												"div")
										if (highlightindex != -1) {
											// 如果原来存在高亮节点，则将背景色改称白色
											autoNodes.eq(highlightindex)
													.css("background-color",
															"white");
											highlightindex--;
										} else {
											highlightindex = autoNodes.length - 1;
										}
										if (highlightindex == -1) {
											// 如果修改索引值以后index变成-1，则将索引值指向最后一个元素
											highlightindex = autoNodes.length - 1;
										}
										// 让现在高亮的内容变成红色
										autoNodes.eq(highlightindex).css(
												"background-color", "red");
									}
									if (keyCode == 40) {
										// 向下
										var autoNodes = $("#auto").children(
												"div")
										if (highlightindex != -1) {
											// 如果原来存在高亮节点，则将背景色改称白色
											autoNodes.eq(highlightindex)
													.css("background-color",
															"white");
										}
										highlightindex++;
										if (highlightindex == autoNodes.length) {
											// 如果修改索引值以后index变成-1，则将索引值指向最后一个元素
											highlightindex = 0;
										}
										// 让现在高亮的内容变成红色
										autoNodes.eq(highlightindex).css(
												"background-color", "red");
									}

								} else if (keyCode == 13) {
									// 如果输入的是回车
									// 下拉框有高亮内容
									if (highlightindex != -1) {
										// 取出高亮节点的文本内容
										var comText = $("#auto").hide()
												.children("div").eq(
														highlightindex).text();
										highlightindex = -1;
										// 文本框中的内容变成高亮节点的内容
										$("#word").val(comText);
									} else {
										// 下拉框没有高亮内容
										alert("文本框中的[" + $("#word").val()
												+ "]被提交了");
										$("#auto").hide();
										highlightindex = -1;
										// 让文本框失去焦点
										$("#word").get(0).blur();
									}

								}
							});
				// 给按钮添加事件，说明提交了搜搜按钮
				$("input[type = 'button']").click( function() {
					alert("文本框的内容为[ " + $("#word").val() + " ]搜搜了");
				});
			});