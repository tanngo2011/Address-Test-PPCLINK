INSERT INTO province (id,        province_name)

VALUE                 (3,         "Bạc Liêu"   ),
                      (5,         "Bắc Giang"  ),
                      (6,         "Bắc Ninh"   ),
                      (9,         "Bình Định"  ),
                      (39,        "Nghệ An"    );



INSERT INTO district (id,   district_name,          unit,             full_name,                     province_id)
VALUE                (626,       "Bạc Liêu"	  ,  "Thành phố" ,       "Thành phố Bạc Liêu, Bạc Liêu",      3      ),
                     (627,   	"Đông Hải"	  ,  	"Huyện",       "Huyện Đông Hải, Bạc Liêu"      ,      3      ),
                     (628,   	"Giá Rai",	        "Thị xã",       "Thị xã Giá Rai, Bạc Liêu"     ,      3      ),
                     (629,   	"Hoà Bình	  "  ,	"Huyện",      "Huyện Hoà Bình, Bạc Liêu"      ,       3      ),
                     (630,   	"Hồng Dân	  "  ,	"Huyện",      "Huyện Hồng Dân, Bạc Liêu"      ,       3      ),
                     (631,   	"Phước Long	  "  ,	"Huyện",      "Huyện Phước Long, Bạc Liêu"    ,       3      ),
                     (632,   	"Vĩnh Lợi	  "  ,	"Huyện",      "Huyện Vĩnh Lợi, Bạc Liêu"      ,       3      ),

                     (367,      "Bắc Giang",    "Thành phố",       "Thành phố Bắc Giang, Bắc Giang",      	5	 ),
                     (368,      "Hiệp Hòa",      "Huyện",           "Huyện Hiệp Hòa, Bắc Giang",        	5	 ),
                     (369,      "Lạng Giang",    "Huyện",           "Huyện Lạng Giang, Bắc Giang",        	5	 ),
                     (370,      "Lục Nam",      "Huyện",           "Huyện Lục Nam, Bắc Giang",           	5	 ),
                     (371,      "Lục Ngạn",     "Huyện",           "Huyện Lục Ngạn, Bắc Giang",          	5	 ),
                     (372,      "Sơn Động",     "Huyện",           "Huyện Sơn Động, Bắc Giang",        	    5	 ),
                     (373,      "Tân Yên",      "Huyện",           "Huyện Tân Yên, Bắc Giang",            	5	 ),
                     (374,      "Việt Yên",     "Huyện",           "Huyện Việt Yên, Bắc Giang",          	5	 ),
                     (375,      "Yên Dũng",     "Huyện",           "Huyện Yên Dũng, Bắc Giang",         	5	 ),
                     (376,      "Yên Thế",      "Huyện ",           "Huyện Yên Thế, Bắc Giang",            	5	 );














INSERT INTO ward (id,     province_id, district_id,         unit,         ward_name)
VALUE            (13122,    3,	         628,	            "Phường" ,        "2"   ),
                 (13124,    3,	         628,	            "Xã"	 ,    "Phong Thạnh Đông" ),
                 (13126,    3,	         628,	            "Xã"	 ,    "Phong Tân"      ),
                 (13128,    3,	         628,	            "Xã"	 ,    "Phong Thạnh"),
                 (13129,    3,	         628,	            "Xã"	 ,    "Phong Thạnh A"),
                 (13130,    3,	         628,	            "Xã"	 ,    "Phong Thạnh Tây"),
                 (13131,    3,	         628,	            "Xã"	 ,    "Tân Thạnh"),

                 (9952,	    3,	         630,	             "Xã",  	"Ninh Thạnh Lợi"),
                 (9954,	    3,	         630,	             "Xã",  	"Vĩnh Lộc"),
                 (9955,	    3,	         630,	             "Xã",  	"Vĩnh Lộc A"),

                 (9905,	    3,	         626,           	"Phường",      	"1"),
                 (9910,	    3,	         626,           	"Phường",      	"7"),
                 (9913,	    3,	         626,           	"Phường",      	"Nhà Mát"),
                 (9915,	    3,	         626,           	"Xã"	,       "Vĩnh Trạch"),
                 (9916,	    3,	         626,           	"Xã"	,       "Vĩnh Trạch Đông"),



                 (5826,	    5,	         367,	            "Xã"	,           "Dĩnh Trì"),
                 (5828,	    5,	         367,	            "Phường",	        "Hoàng Văn Thụ"),
                 (5829,	    5,	         367,	            "Phường",	        "Lê Lợi"),
                 (5831,	    5,	         367,	            "Phường",	        "Ngô Quyền"),
                 (5832,	    5,	         367,	            "Xã"	,           "Song Khê"),
                 (5833,	    5,	         367,	            "Xã"	,           "Song Mai"),
                 (5834,	    5,	         367,	            "Xã"	,           "Tân Mỹ"),
                 (5837,	    5,	         367,	            "Phường",	        "Trần Nguyên Hãn"),
                 (5838,	    5,	         367,	            "Phường",	        "Trần Phú"),

                 (5873,	    5,	         369,	            "Thị trấn",	        "Kép"),
                 (5875,	    5,	         369,	            "Xã"	  ,         "Mỹ Thái"),
                 (5877,	    5,	         369,	            "Xã"	  ,         "Nghĩa Hưng"),
                 (5881,	    5,	         369,	            "Xã"	  ,         "Tân Hưng"),
                 (5882,	    5,	         369,	            "Xã"	  ,         "Tân Thanh"),
                 (5885,	    5,	         369,	            "Xã"	  ,         "Tiên Lục"),
                 (5887,	    5,	         369,	            "Xã"	  ,         "Xuân Hương"),
                 (5888,	    5,	         369,	            "Xã"	  ,         "Xương Lâm");

