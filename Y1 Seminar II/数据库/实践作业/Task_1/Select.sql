select a.ROUTENAME 线路名称,
       b.ROUTETYPENAME 线路类别,
       c2.UNINAME 所属单位,
       c1.UNINAME 所属车队,
       d.VALUE 线路车辆类型
  from G_ROUTENUM a,
       g_Routetype b,
       g_Unitnum c1,
       g_Unitnum c2,
       g_dicinfo d
 where a.routetype = b.routetype
   and substr(a.routenum, 1, 4) = c1.unitnum
   and substr(a.routenum, 1, 2) = c2.unitnum
   and a.routebustype = d.code
   and d.dicname = 'ROUTEBUSTYPE'
;


select a.ROUTENAME,
       b.ROUTETYPENAME,
       c3.UNINAME,
       c2.UNINAME,
       d.VALUE
  from G_ROUTENUM  a,
       g_Routetype b,
       g_Unitnum   c1,
       g_Unitnum   c2,
       g_unitnum   c3,
       g_dicinfo   d
 where a.routenum = c1.unitnum
   and a.routetype = b.routetype
   and c1.parentnum = c2.unitnum
   and c2.parentnum = c3.unitnum
   and a.routebustype = d.code
   and d.dicname = 'ROUTEBUSTYPE'
;


