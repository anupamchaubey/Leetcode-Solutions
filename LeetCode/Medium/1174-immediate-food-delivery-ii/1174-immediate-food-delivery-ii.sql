# Write your MySQL query statement below

select round(sum(u.order_date=u.customer_pref_delivery_date)*100 /count(*), 2) as immediate_percentage

From Delivery u
Join(
    select customer_id, min(order_date) as first_order
    From Delivery 
    Group By customer_id
)d
On d.customer_id=u.customer_id
And d.first_order=u.order_date
