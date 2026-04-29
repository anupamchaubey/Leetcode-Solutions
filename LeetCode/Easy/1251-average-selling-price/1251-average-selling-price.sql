# Write your MySQL query statement below


select p.product_id,
IFNULL(round(sum(p.price*u.units)/sum(u.units), 2), 0) as average_price
from Prices p
Left Join UnitsSold u
On p.product_id=u.product_id AND purchase_date>=start_date AND purchase_date<=end_date
GROUP BY p.product_id
