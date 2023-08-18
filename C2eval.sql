
select productid, sale_price - market_price from products
order by productid;


select brand, type from products
group by brand, type
order by brand, type;


select count(*) from customers 
where state like 'a%' or state like 'e%' or state like 'i%' or state like 'o%' or state like 'u%';


select shipperid, sum(total_order_amount) from orders
group by shipperid
order by shipperid;


