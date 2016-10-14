<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="line-big">
	<div class="xl1"></div>
	<div class="xl3">
		<div class="panel border-back">
			<div class="panel-body text-center">
				<h1>
					<strong>编辑课程</strong>
				</h1>
			</div>
			<div class="panel-foot bg-back border-back">
				<div class="content_wrap">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree" style="min-height: 400px;"></ul>
					</div>
				</div>
			</div>
			<div class="panel-body text-left">
				<span class="icon-info-circle"></span> 课程最多两个级别。</br> <span class="icon-info-circle"></span> 添加课程时,输入内容中间用英文逗号,隔开即可批量添加课程。如输入"课程1,课程2,课程3"即可一次性添加三个课程"课程1","课程2","课程3"。
			</div>
		</div>
	</div>
	<div class="xl7">
		<div class="panel border-back margin-big-top">
			<div class="panel-body text-center border-back">
				<h2>
					<strong>当前操作课程类别为：<span class="text-white bg-blue radius-big" id="current_custom_type_span" data-id=""></span></strong>
				</h2>
			</div>
			<div class="panel-foot bg-white border-back">
				<div class="line-big">
					<div class="xl6">
						<div class="label">
							<label for="course_video_mp4">*课程视频 MP4格式(最多可添加一个视频,视频宽度为960px,高度为400px时显示效果最好.)</label>
						</div>
						<div class="field">
							<textarea name="content" class="course_video_mp4_textarea" id="course_video_mp4"></textarea>
						</div>
					</div>
					<div class="xl6">
						<div class="label">
							<label for="course_video_flv">课程视频 FLV格式(最多可添加一个视频,视频宽度为960px,高度为400px时显示效果最好.)</label>
						</div>
						<div class="field">
							<textarea name="content" class="course_video_flv_textarea" id="course_video_flv"></textarea>
						</div>
					</div>
				</div>
				<div class="line-big G-MarginTop20">
					<div class="xl6">
						<div class="label">
							<label for="doc_1">演示文稿(PDF格式)</label>
						</div>
						<div class="field">
							<textarea name="content" class="course_doc_1_textarea" id="course_doc_1"></textarea>
						</div>
					</div>
					<div class="xl6">
						<div class="label">
							<label for="doc_2">重点难点(PDF格式)</label>
						</div>
						<div class="field">
							<textarea name="content" class="course_doc_2_textarea" id="course_doc_2"></textarea>
						</div>
					</div>
				</div>
				<div class="line-big G-MarginTop20">
					<div class="xl6">
						<div class="label">
							<label for="doc_3">教学设计(PDF格式)</label>
						</div>
						<div class="field">
							<textarea name="content" class="course_doc_3_textarea" id="course_doc_3"></textarea>
						</div>
					</div>
					<div class="xl6">
						<div class="label">
							<label for="doc_4">习题作业(PDF格式)</label>
						</div>
						<div class="field">
							<textarea name="content" class="course_doc_4_textarea" id="course_doc_4"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-foot bg-white border-back">
				<div class="line-big">
					<div class="xl12 text-center">
						<button class="button border-blue" id="submit_goods_type_picture_button">提交课程相关信息</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="xl1"></div>
</div>
<div id="rMenu">
	<ul>
		<li id="m_add_grade_1" onclick="add_grade_1_node();">增加章节</li>
		<li id="m_add_grade_2" onclick="add_grade_2_node();">增加课程</li>
		<li id="m_del" onclick="removeTreeNode();">删除</li>
		<li id="m_reame" onclick="renameTreeNode();">重命名</li>
	</ul>
</div>
<div style="display: none;" id="courseJson">${courseJson }</div>
<div style="display: none" id="time_temp_div"></div>
<script type="text/javascript">
	$(function()
	{
		var myDate = new Date();
		$("#time_temp_div").html(myDate.getHours() + "-" + myDate.getMinutes() + "-" + myDate.getSeconds() + "-" + myDate.getMilliseconds());
		$(".course_video_mp4_textarea").attr("id", "course_video_mp4" + $("#time_temp_div").html());
		$(".course_video_flv_textarea").attr("id", "course_video_flv" + $("#time_temp_div").html());
		$(".course_doc_1_textarea").attr("id", "course_doc_1" + $("#time_temp_div").html());
		$(".course_doc_2_textarea").attr("id", "course_doc_2" + $("#time_temp_div").html());
		$(".course_doc_3_textarea").attr("id", "course_doc_3" + $("#time_temp_div").html());
		$(".course_doc_4_textarea").attr("id", "course_doc_4" + $("#time_temp_div").html());
		var option_course_video_mp4 =
		{
			initialContent : "",//初始化编辑器的内容
			//textarea:'editorValue',//设置提交时编辑器内容的名字
			initialFrameWidth : "100%", //初始化编辑器宽度,默认1000，可以设置成百分比
			initialFrameHeight : 150, //初始化编辑器高度,默认320
			autoClearinitialContent : false,//是否自动清除编辑器初始内容
			maxImageSideLength : 500,
			wordCount : false,
			toolbars : [ [ 'undo', 'redo', '|', 'attachment' ] ]
		};
		course_video_mp4_editor = UE.getEditor($(".course_video_mp4_textarea").attr("id"), option_course_video_mp4);
		course_video_flv_editor = UE.getEditor($(".course_video_flv_textarea").attr("id"), option_course_video_mp4);
		course_doc_1_editor = UE.getEditor($(".course_doc_1_textarea").attr("id"), option_course_video_mp4);
		course_doc_2_editor = UE.getEditor($(".course_doc_2_textarea").attr("id"), option_course_video_mp4);
		course_doc_3_editor = UE.getEditor($(".course_doc_3_textarea").attr("id"), option_course_video_mp4);
		course_doc_4_editor = UE.getEditor($(".course_doc_4_textarea").attr("id"), option_course_video_mp4);

		$("#submit_goods_type_picture_button").click(function()
		{
			var custom_type_id = $("#current_custom_type_span").attr("data-id");
			var course_video_mp4 = course_video_mp4_editor.getContent();
			var course_video_flv = course_video_flv_editor.getContent();
			var course_doc_1 = course_doc_1_editor.getContent();
			var course_doc_2 = course_doc_2_editor.getContent();
			var course_doc_3 = course_doc_3_editor.getContent();
			var course_doc_4 = course_doc_4_editor.getContent();

			if (custom_type_id.length <= 0)
			{
				alert("没有找到此课程");
				return false;
			}

			var tips = "";
			var tips_number = 1;
			$("input[data-regex]").each(function(i, dom)
			{
				var n = $(dom);
				if (new RegExp(n.attr("data-regex")).test(n.val()) == false)
				{
					tips += tips_number++ + " . \"" + n.val() + "\" 不满足输入要求;\n";
				}
			});

			if (tips.length > 0)
			{
				alert(tips + "\n请检查一下重新输入.");
				return false;
			}

			var submit_goods_type_picture_button_html = $("#submit_goods_type_picture_button").html();
			$.ajax(
			{
				url : "goods_type/goods_type_set_new_pic_do",
				type : "POST",
				dataType : "json",
				beforeSend : function(XMLHttpRequest)
				{
					$("#submit_goods_type_picture_button").attr("disabled", "disabled");
					$("#submit_goods_type_picture_button").html("正在提交信息中...");
				},
				data :
				{
					'courseId' : custom_type_id,
					'videoMp4' : course_video_mp4,
					'videoFlv' : course_video_flv,
					'doc1' : course_doc_1,
					'doc2' : course_doc_2,
					'doc3' : course_doc_3,
					'doc4' : course_doc_4,
				},
				success : function(json, textStatus)
				{
					if (json.success == true)
					{
						alert("课程信息设置成功");
					}
					else
					{
						alert(json.info);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown)
				{
					alert("提交失败，请仔细检查您的输入是否满足要求。");
				},
				complete : function(XMLHttpRequest, textStatus)
				{
					$("#submit_goods_type_picture_button").removeAttr("disabled");
					$("#submit_goods_type_picture_button").html(submit_goods_type_picture_button_html);
				}
			});
		});

	});

	var setting =
	{
		view :
		{
			dblClickExpand : false,
			showLine : false
		},
		data :
		{
			simpleData :
			{
				enable : true
			}
		},
		view :
		{
			selectedMulti : false
		},
		callback :
		{
			onClick : onClick,
			onRightClick : OnRightClick
		}
	};

	var zNodes = eval('(' + $("#courseJson").html() + ')');

	function onClick(e, treeId, treeNode)
	{
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		//zTree.expandNode(treeNode);

		if (treeNode.grade == "2")
		{
			$("#current_custom_type_span").html(treeNode.name);
			$("#current_custom_type_span").attr("data-id", treeNode.id);

			$.post("goods_type/goods_type_get_old_pic_do",
			{
				"commonStr" : treeNode.id
			}, function(json)
			{
				if (json.success == true)
				{
					if (json.courseInfo.videoMp4 == null || json.courseInfo.videoMp4 == "")
					{
						course_video_mp4_editor.setContent("课程\"" + treeNode.name + "\"暂无对应MP4，请上传");
					}
					else
					{
						course_video_mp4_editor.setContent('<a href="'+json.courseInfo.videoMp4+'">已上传.mp4</a>');
					}

					if (json.courseInfo.videoFlv == null || json.courseInfo.videoFlv == "")
					{
						course_video_flv_editor.setContent("课程\"" + treeNode.name + "\"暂无对应FLV，请上传");
					}
					else
					{
						course_video_flv_editor.setContent('<a href="'+json.courseInfo.videoFlv+'">已上传.flv</a>');
					}

					if (json.courseInfo.doc1 == null || json.courseInfo.doc1 == "")
					{
						course_doc_1_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					}
					else
					{
						course_doc_1_editor.setContent('<a href="'+json.courseInfo.doc1+'">演示文稿.pdf</a>');
					}

					if (json.courseInfo.doc2 == null || json.courseInfo.doc2 == "")
					{
						course_doc_2_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					}
					else
					{
						course_doc_2_editor.setContent('<a href="'+json.courseInfo.doc2+'">重点难点.pdf</a>');
					}

					if (json.courseInfo.doc3 == null || json.courseInfo.doc3 == "")
					{
						course_doc_3_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					}
					else
					{
						course_doc_3_editor.setContent('<a href="'+json.courseInfo.doc3+'">教学设计.pdf</a>');
					}

					if (json.courseInfo.doc4 == null || json.courseInfo.doc4 == "")
					{
						course_doc_4_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					}
					else
					{
						course_doc_4_editor.setContent('<a href="'+json.courseInfo.doc4+'">习题作业.pdf</a>');
					}
				}
				else
				{
					course_video_mp4_editor.setContent("课程\"" + treeNode.name + "\"暂无对应MP4，请上传");
					course_video_flv_editor.setContent("课程\"" + treeNode.name + "\"暂无对应FLV，请上传");
					course_doc_1_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					course_doc_2_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					course_doc_3_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
					course_doc_4_editor.setContent("课程\"" + treeNode.name + "\"暂无对应PDF，请上传");
				}
			},
			//返回类型
			"json");
		}
	}
	function OnRightClick(event, treeId, treeNode)
	{
		if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0)
		{
			zTree.cancelSelectedNode();
			showRMenu("root", event.clientX, event.clientY);
		}
		else if (treeNode && !treeNode.noR)
		{
			zTree.selectNode(treeNode);
			//alert("node" + treeNode.grade+","+("node" + treeNode.grade).length);
			showRMenu("node" + treeNode.grade, event.clientX, event.clientY);
		}
	}
	function showRMenu(type, x, y)
	{
		$("#rMenu ul").show();
		if (type == "root")
		{
			$("#m_add_grade_1").show();
			$("#m_add_grade_2").hide();
			$("#m_del").hide();
			$("#m_reame").hide();
		}
		else
		{
			$("#m_del").show();
			$("#m_reame").show();
			if (type == "node1")
			{
				$("#m_add_grade_1").hide();
				$("#m_add_grade_2").show();
			}
			if (type == "node2")
			{
				$("#m_add_grade_1").hide();
				$("#m_add_grade_2").hide();
			}
		}
		rMenu.css(
		{
			"top" : y + "px",
			"left" : x + "px",
			"visibility" : "visible"
		});

		$("body").bind("mousedown", onBodyMouseDown);
	}
	function add_grade_1_node()
	{
		hideRMenu();
		var type_name_str = prompt("请输入课程名称,批量添加中间用英文逗号,隔开");
		if (type_name_str.length <= 0)
		{
			alert("不满足课程名称要求");
			return false;
		}
		$.post("goods_type/goods_type_add_do",
		{
			"courseName" : type_name_str
		}, function(json)
		{
			if (json.success == false)
			{
				alert(json.info);
			}
			else
			{
				$.each(json.course, function(i, n)
				{
					var newNode =
					{
						id : n.courseId,
						name : n.courseName,
						pId : n.courseParentId,
						grade : 1
					};
					zTree.addNodes(null, newNode);
				});
			}
		},
		//返回课程
		"json");
	}
	function add_grade_2_node()
	{
		hideRMenu();
		var type_name_str = prompt("请输入课程名称");
		if (type_name_str.length <= 0)
		{
			alert("不满足课程名称要求");
			return false;
		}
		var newNode =
		{
			name : type_name_str
		};
		if (zTree.getSelectedNodes()[0])
		{
			$.post("goods_type/goods_type_add_do",
			{
				"courseName" : type_name_str,
				"courseParentId" : zTree.getSelectedNodes()[0].id
			}, function(json)
			{
				if (json.success == false)
				{
					alert(json.info);
				}
				else
				{

					$.each(json.course, function(i, n)
					{
						var newNode =
						{
							id : n.courseId,
							name : n.courseName,
							pId : n.courseParentId,
							grade : parseInt(zTree.getSelectedNodes()[0].grade) + 1
						};
						newNode.checked = zTree.getSelectedNodes()[0].checked;
						zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
					});
				}
			},
			//返回课程
			"json");
		}
	}
	function removeTreeNode()
	{
		hideRMenu();
		var nodes = zTree.getSelectedNodes();
		if (nodes && nodes.length > 0)
		{
			if (nodes[0].children && nodes[0].children.length > 0)
			{
				var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
				if (confirm(msg) == true)
				{
					var ids = [];
					ids = getChildren(ids, nodes[0]);
					$.post("goods_type/goods_type_delete_do",
					{
						"commonStr" : ids.toString()
					}, function(json)
					{
						if (json.success == false)
						{
							alert(json.info);
						}
						else
						{
							zTree.removeNode(nodes[0]);
						}
					},
					//返回课程
					"json");
				}

			}
			else
			{
				$.post("goods_type/goods_type_delete_do",
				{
					"commonStr" : nodes[0].id
				}, function(json)
				{
					if (json.success == false)
					{
						alert(json.info);
					}
					else
					{
						zTree.removeNode(nodes[0]);
					}
				},
				//返回课程
				"json");
			}
		}
	}

	//ids是一个数组 返回结果数组     treeNode是选中的节点
	function getChildren(ids, treeNode)
	{
		ids.push(treeNode.id);
		if (treeNode.isParent)
		{
			for ( var obj in treeNode.children)
			{
				getChildren(ids, treeNode.children[obj]);
			}
		}
		return ids;
	}
	function renameTreeNode()
	{
		hideRMenu();
		var type_name_str = prompt("请输入课程名称");
		if (type_name_str.length <= 0)
		{
			alert("不满足课程名称要求");
			return false;
		}
		var nodes = zTree.getSelectedNodes();
		if (nodes && nodes.length > 0)
		{
			$.post("goods_type/goods_type_update_do",
			{
				"courseId" : nodes[0].id,
				"courseName" : type_name_str
			}, function(json)
			{
				if (json.success == false)
				{
					alert(json.info);
				}
				else
				{
					nodes[0].name = type_name_str;
					zTree.updateNode(nodes[0]);
				}
			},
			//返回课程
			"json");
		}
	}

	function hideRMenu()
	{
		if (rMenu)
			rMenu.css(
			{
				"visibility" : "hidden"
			});
		$("body").unbind("mousedown", onBodyMouseDown);
	}
	function onBodyMouseDown(event)
	{
		if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0))
		{
			rMenu.css(
			{
				"visibility" : "hidden"
			});
		}
	}
	var zTree, rMenu;
	$(document).ready(function()
	{
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		zTree = $.fn.zTree.getZTreeObj("treeDemo");
		rMenu = $("#rMenu");
	});
</script>