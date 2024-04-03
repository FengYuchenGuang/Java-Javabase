-- all 和 any 的使用

-- 请思考:显示工资比部门 30 的所有员工的工资高的员工的姓名、工资和部门号
SELECT ename, sal, deptno
	FROM emp05
	WHERE sal > ALL(
		SELECT sal
		FROM emp05
		WHERE deptno = 30
		);

-- 可以这样写
SELECT ename, sal, deptno
	FROM emp05
	WHERE sal > (
		SELECT MAX(sal)
		FROM emp05
		WHERE deptno = 30
		);

-- 请思考:如何显示工资比部门 30 的其中一个员工的工资高的员工的姓名、工资和部门号
SELECT ename, sal, deptno
	FROM emp05
	WHERE sal > ANY(
		SELECT sal
		FROM emp05
		WHERE deptno = 30
		);

SELECT ename, sal, deptno
	FROM emp05
	WHERE sal > (
		SELECT MIN(sal)
		FROM emp05
		WHERE deptno = 30
		);


-- 查询 ecshop 中各个类别中，价格最高的商品
-- 查询 商品表
-- 先得到 各个类别中，价格最高的商品 max + group by cat_id, 当做临时表
-- 把子查询当做一张临时表可以解决很多很多复杂的查询
SELECT cat_id , MAX(shop_price)
	FROM ecs_goods
	GROUP BY cat_id

-- 这个最后答案
SELECT goods_id, ecs_goods.cat_id, goods_name, shop_price
	FROM (  SELECT cat_id , MAX(shop_price) AS max_price
		FROM ecs_goods
		GROUP BY cat_id
		) temp , ecs_goods
	WHERE temp.cat_id = ecs_goods.cat_id
	AND temp.max_price = ecs_goods.shop_price



