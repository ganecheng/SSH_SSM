var FormValidation = function()
{

	var handleValidation1 = function()
	{
		// for more info visit the official plugin documentation:
		// http://docs.jquery.com/Plugins/Validation

		var form1 = $('#form_sample_1');
		var error1 = $('.alert-danger', form1);
		var success1 = $('.alert-success', form1);

		form1.validate(
		{
			errorElement : 'span', // default input error message container
			errorClass : 'help-block', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			ignore : "",
			rules :
			{
				'listRecord.schoolName' :
				{
					required : true
				},
				'listRecord.majorName' :
				{
					required : true
				},
				'listRecord.className' :
				{
					required : true
				},
				'listRecord.studentId' :
				{
					minlength : 10,
					required : true
				},
				'listRecord.studentName' :
				{
					minlength : 2,
					required : true
				},
				'listRecord.sex' :
				{
					required : true
				}
			},

			invalidHandler : function(event, validator)
			{ // display error alert on form submit
				success1.hide();
				error1.show();
				App.scrollTo(error1, -200);
			},

			highlight : function(element)
			{ // hightlight error inputs
				$(element).closest('.form-group').addClass('has-error'); // set error class to the control group
			},

			unhighlight : function(element)
			{ // revert the change done by hightlight
				$(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
			},

			success : function(label)
			{
				label.closest('.form-group').removeClass('has-error'); // set success class to the control group
			},

			submitHandler : function(form)
			{
				error1.hide();
				App.blockUI(
				{
					iconOnly : true,
				});
				$.post("admin/admin_add_listrecord_do", form1.serialize(), function(json)
				{
					if (json.success == true)
					{
						$("#add_listrecord_modal").find(".modal-content").html("");
						$("#add_listrecord_modal").modal("hide");
						App.blockUI(
						{
							message : '<h2>操作成功！正在载入中 ...</h2>',
							iconOnly : false,
							overlayCSS :
							{
								backgroundColor : '#fff',
								opacity : 0.5,
								cursor : 'wait'
							}
						});
						$("#list_record_div").load($("#list_record_div").attr("data-link"), {}, function()
						{
							setTimeout(App.unblockUI, 500);
						});
					}
					else
					{
						alert("操作失败：" + json.info);
						App.unblockUI();
					}
				}, "json");
			}
		});

	}

	return	{
		// main function to initiate the module
		init : function()
		{

			handleValidation1();

		}

	};

}();
