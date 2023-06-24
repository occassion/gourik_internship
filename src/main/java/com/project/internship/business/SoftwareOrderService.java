package com.project.internship.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component

public class SoftwareOrderService {
    @Autowired
    @Qualifier("orderJdbcTemplate")
    private JdbcTemplate orderJdbcTemplate;

    /*
       this method will takes input arguments start date,end date,department
       @return total items
     */
    public String getTotalItems(String startDate, String endDate, String department) {
        int totalitems = 0;
        String total_query = "select sum(seats) from software_order where order_date between to_date(?,'YYY-MM-DD hh24:mi:ss')) and to_date(?,'YYY-MM-DD hh24:mi:ss') and department=?";
        try {
            totalitems = orderJdbcTemplate.queryForObject(total_query, new Object[]{startDate, endDate, department}, Integer.class);

        } catch (Exception ex) {

        }

        return String.valueOf(totalitems);
        }
    /*
       this method will takes input arguments start date,end date,department
       @return total items
     */
        public String getNthMostTotalItem(String quantity, String price, String startDate, String endDate){
            String second_sold ="";
            String fourth_sold="";

            String second_highest = "select max(st.seats) from software_order st where st.seats<select max(sw.seats) from software_order sw where st.order_date between to_date(?,'YYY-MM-DD hh24:mi:ss')) and to_date(?,'YYY-MM-DD hh24:mi:ss')";
            String foruth_highhest="SELECT TOP 1 software FROM\n" +
                    "(\n" +
                    "      SELECT DISTINCT TOP 3 amount FROM software_order ORDER BY amount DESC\n" +
                    "     ) AS T ORDER BY amount ASC";
            try {
                second_sold = orderJdbcTemplate.queryForObject(second_highest, new Object[]{startDate, endDate}, String.class);
                fourth_sold = orderJdbcTemplate.queryForObject(foruth_highhest, new Object[]{startDate, endDate}, String.class);


            } catch (Exception ex) {

            }

            return second_sold+fourth_sold;

        }

        public String getPercentDepartmntWiseSoldItem(String startDate, String endDate){
            int percentage = 0;
            String percentage_query = "select department, (sum(seats)/(select sum(seats) from software_order)*100) as percentage from software_order where order_date between to_date(?,'YYY-MM-DD hh24:mi:ss') and to_date(?,'YYY-MM-DD hh24:mi:ss') group by department";
            try {
                percentage = orderJdbcTemplate.queryForObject(percentage_query, new Object[]{startDate, endDate}, Integer.class);

            } catch (Exception ex) {

            }

            return String.valueOf(percentage)+"%";
         }

        public String getMonthlySales(String product, String year){
            int totalSales = 0;
            String percentage_query = "select sum(seats) from software_order where software=? and order_date=to_date(?,'YYY-MM-DD hh24:mi:ss')";
            try {
                totalSales = orderJdbcTemplate.queryForObject(percentage_query, new Object[]{product, year}, Integer.class);

            } catch (Exception ex) {

            }

            return String.valueOf(totalSales);
        }
    }


