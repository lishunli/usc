//FCKConfig.AutoDetectLanguage = false;
//自己的配置
//1.修改工具栏的按钮
FCKConfig.ToolbarSets["MyFCK"] = [
		[ 'Source', 'DocProps' ],
		[ 'Bold', 'Italic', 'Underline', 'StrikeThrough', '-', 'Subscript',
				'Superscript' ],
		[ 'OrderedList', 'UnorderedList', '-', 'Outdent', 'Indent',
				'Blockquote', 'CreateDiv' ],
		[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyFull' ],
		[ 'Link', 'Unlink', 'Anchor' ],
		[ 'Image', 'Flash', 'Table', 'Rule', 'Smiley', 'SpecialChar',
				'PageBreak' ], '/',
		[ 'Style', 'FontFormat', 'FontName', 'FontSize' ],
		[ 'TextColor', 'BGColor' ], [ 'FitWindow', 'ShowBlocks', '-', 'About' ] // No comma for the last row.
];
FCKConfig.ToolbarSets["Simple"] = [[ 'Source', 'About']];

//2.修改字体，让其支持中文字体
FCKConfig.FontNames = '宋体;楷体;微软雅黑;隶书;Arial;Times New Roman';
FCKConfig.FontSizes		= '8;10;12;14;16;18;20;22;24;26;28' ;
//3.修改Enter（段落）和shift + Enter（回车）的行为，让其行为互反
FCKConfig.EnterMode = 'br' ;			// p | div | br
FCKConfig.ShiftEnterMode = 'p' ;	// p | div | br
//4.修改表情图片
FCKConfig.SmileyPath	= FCKConfig.BasePath + 'images/smiley/qq/' ;
FCKConfig.SmileyImages	= ['1.gif' , '2.gif' , '3.gif' , '4.gif'  , '6.gif' , '7.gif' , '8.gif' , '9.gif' , '10.gif' , '11.gif' , '12.gif' , '13.gif' , '14.gif' , '15.gif' , '16.gif' , '17.gif' , '18.gif' , '19.gif' , '20.gif'] ;
FCKConfig.SmileyColumns = 4 ;
FCKConfig.SmileyWindowWidth		= 760 ;
FCKConfig.SmileyWindowHeight	= 760 ;

//5.配置客户端的上传服务器图片格式，配置服务器端的，在fckeditor.properties中配置
//FCKConfig.ImageUploadAllowedExtensions	= ".(txt|jpg|gif|jpeg|png|bmp|rar|abc)$" ;		// empty for all
