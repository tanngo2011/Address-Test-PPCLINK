INSERT INTO province (id,        province_name)

VALUE                (3,       	 "Bạc Liêu"   ),
                      (5,         "Bắc Giang"  ),
                      (6,         "Bắc Ninh"   ),
                      (9,         "Bình Định"  ),
                      (39,        "Nghệ An"    );



INSERT INTO district (id,   district_name,          unit,             full_name,                     province_id)
VALUE                (626,       "Bạc Liêu"	  ,  "Thành phố" ,       "Thành phố Bạc Liêu, Bạc Liêu",  	    3       ),
                     (627,   	"Đông Hải"	  ,  	"Huyện",       "Huyện Đông Hải, Bạc Liêu"      ,       3      ),
                     (628,   	"Giá Rai",	"Thị xã",       "Thị xã Giá Rai, Bạc Liêu"     ,        3      ),
                     (629,   	"Hoà Bình	  "  ,	"Huyện",      "Huyện Hoà Bình, Bạc Liêu"      ,       3      ),
                     (630,   	"Hồng Dân	  "  ,	"Huyện",      "Huyện Hồng Dân, Bạc Liêu"      ,       3      ),
                     (631,   	"Phước Long	  "  ,	"Huyện",      "Huyện Phước Long, Bạc Liêu"    ,       3      ),
                     (632,   	"Vĩnh Lợi	  "  ,	"Huyện",      "Huyện Vĩnh Lợi, Bạc Liêu"      ,       3      );




INSERT INTO ward (id,     province_id, district_id,         unit,         ward_name)
VALUE            (13122,    3,	         628,	            "Phường" ,        "1"   ),
                 (13124,    3,	         628,	            "Xã"	 ,    "Phong Thạnh Đông" ),
                 (13126,    3,	         628,	            "Xã"	 ,    "Phong Tân"      ),
                 (13128,    3,	         628,	            "Xã"	 ,    "Phong Thạnh"),
                 (13129,    3,	         628,	            "Xã"	 ,    "Phong Thạnh A"),
                 (13130,    3,	         628,	            "Xã"	 ,    "Phong Thạnh Tây"),
                 (13131,    3,	         628,	            "Xã"	 ,    "Tân Thạnh");

