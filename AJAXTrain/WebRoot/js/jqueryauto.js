//��ʾ��ǰ�����Ľڵ�
var highlightindex = -1;
var timeOutId;
$(document)
		.ready( function() {
			// �Զ���ȫ���ʼһ������������
				var wordInput = $("#word");
				var wordInputOffset = wordInput.offset();
				$("#auto").hide().css("border", "1.5px solid black").css(
						"position", "absolute").css("z-index", "99").css("top",
						wordInputOffset.top + wordInput.height() + 5 + "px")
						.css("left", wordInputOffset.left + "px").width(
								wordInput.width() + 2);
				;
				// ���ı�����Ӽ��̰��²��������¼�
				$("#word")
						.keyup( function(event) {
							// ���ı����еļ����¼�
								var myEvent = event || window.event();
								var keyCode = myEvent.keyCode;
								if (keyCode >= 65 && keyCode <= 90
										|| keyCode == 8 || keyCode == 46) {
									// 1.���Ȼ�ȡ�ı����е�����
									var wordText = wordInput.val();
									var autoNode = $("#auto");
									if (wordText != "") {
										// 2.���ı����е����ݷ��ͷ�������
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
																		// 3.��dom����dataת����JQuery�Ķ���
																		var jqueryObj = $(data);
																		// 4.�ҵ����е�word�ڵ�
																		var wordNodes = jqueryObj
																				.find("word");
																		// 5.�������е�word�ڵ��½�div�ڵ㣬����ӵ�div���ڵ���

																		// ���ԭ�ȵ�div����
																		autoNode
																				.html("");
																		wordNodes
																				.each( function(
																						i) {
																					// ��ȡ��������
																					var wordNode = $(this);
																					// �½�div�ڵ㣬����������ӵ��½��Ľڵ���
																					var newDivNode = $(
																							"<div>")
																							.attr(
																									"id",
																									i);
																					// ���½��Ľڵ���뵽������Ľڵ���
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
																					// �������ĵ���¼�
																					newDivNode
																							.click( function() {
																								// ȡ�������ڵ���ı�����
																								var comText = $(
																										this)
																										.text();
																								$(
																										"#auto")
																										.hide();
																								highlightindex = -1;
																								// �ı����е����ݱ�ɸ����ڵ������
																								$(
																										"#word")
																										.val(
																												comText);

																							});

																				});
																		// ��ʾdiv������������������ݿⷵ��
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
									// �����������������°���
									if (keyCode == 38) {
										// ����
										var autoNodes = $("#auto").children(
												"div")
										if (highlightindex != -1) {
											// ���ԭ�����ڸ����ڵ㣬�򽫱���ɫ�ĳư�ɫ
											autoNodes.eq(highlightindex)
													.css("background-color",
															"white");
											highlightindex--;
										} else {
											highlightindex = autoNodes.length - 1;
										}
										if (highlightindex == -1) {
											// ����޸�����ֵ�Ժ�index���-1��������ֵָ�����һ��Ԫ��
											highlightindex = autoNodes.length - 1;
										}
										// �����ڸ��������ݱ�ɺ�ɫ
										autoNodes.eq(highlightindex).css(
												"background-color", "red");
									}
									if (keyCode == 40) {
										// ����
										var autoNodes = $("#auto").children(
												"div")
										if (highlightindex != -1) {
											// ���ԭ�����ڸ����ڵ㣬�򽫱���ɫ�ĳư�ɫ
											autoNodes.eq(highlightindex)
													.css("background-color",
															"white");
										}
										highlightindex++;
										if (highlightindex == autoNodes.length) {
											// ����޸�����ֵ�Ժ�index���-1��������ֵָ�����һ��Ԫ��
											highlightindex = 0;
										}
										// �����ڸ��������ݱ�ɺ�ɫ
										autoNodes.eq(highlightindex).css(
												"background-color", "red");
									}

								} else if (keyCode == 13) {
									// ���������ǻس�
									// �������и�������
									if (highlightindex != -1) {
										// ȡ�������ڵ���ı�����
										var comText = $("#auto").hide()
												.children("div").eq(
														highlightindex).text();
										highlightindex = -1;
										// �ı����е����ݱ�ɸ����ڵ������
										$("#word").val(comText);
									} else {
										// ������û�и�������
										alert("�ı����е�[" + $("#word").val()
												+ "]���ύ��");
										$("#auto").hide();
										highlightindex = -1;
										// ���ı���ʧȥ����
										$("#word").get(0).blur();
									}

								}
							});
				// ����ť����¼���˵���ύ�����Ѱ�ť
				$("input[type = 'button']").click( function() {
					alert("�ı��������Ϊ[ " + $("#word").val() + " ]������");
				});
			});