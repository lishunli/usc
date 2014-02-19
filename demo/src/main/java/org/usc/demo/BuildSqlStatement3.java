package org.usc.demo;


/**
 *
 * @author Shunli
 */
public class BuildSqlStatement3 {

    public static void main(String[] args) {
        // //method 1
        // StringBuffer buffer = new StringBuffer();
        //
        // for (int i = 0; i < 10; i++) {
        // if (i != 0) {
        // buffer.append(" union all ");
        // }
        //
        // buffer.append("select * from member_" + i + " where uid = ? and status = '1' and serverid = ? ");
        // }
        //
        // System.out.println(buffer);

        // // method 2
        // StringBuffer sb = new StringBuffer("select count(1) from (");
        //
        // for (int i = 0; i < 10; i++) {
        // if (i != 0) {
        // sb.append(" union all ");
        // }
        // sb.append(" select 1 from member_" + i + " where uid = ? and status = '1' and serverid = ? ");
        //
        // }
        // sb.append(" ) t");
        //
        // System.out.println(sb);

        // // method 3
        // StringBuffer sb = new StringBuffer("select count(1) from (");
        //
        // for (int i = 0; i < 10; i++) {
        // if (i != 0) {
        // sb.append(" union all ");
        // }
        // sb.append(" select 1 from member_" + i + " where uid = ? and serverid = ? and status = '2' and joindate = ? ");
        //
        // }
        // sb.append(" ) t");
        // System.out.println(sb);

        // // method 4
        // StringBuffer sb = new StringBuffer("select count(1) from (");
        //
        // for (int i = 0; i < 10; i++) {
        // if (i != 0) {
        // sb.append(" union all ");
        // }
        // sb.append(" select 1 from member_" + i + " where uid = ? and status = '1' ");
        //
        // }
        // sb.append(" ) t");
        //
        // System.out.println(sb);

        // method5
        StringBuffer sb = new StringBuffer("select count(1) from (");

        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                sb.append(" union all ");
            }
            sb.append(" select 1 from member_" + i + " where uid = ? and serverid = ? and status = '1' and type = '3' ");

        }
        sb.append(" ) t");
        System.out.println(sb);

        // StringBuffer sb = new StringBuffer("select * from team where status = '2' ");
        //
        // String ranktaskDate ="";
        // // mabye ReRun rank job.
        // if (StringUtils.isNotEmpty(ranktaskDate )) {
        // sb.append(" and (ranktaskdate = '' or ranktaskdate < '").append(ranktaskDate).append("')");
        // }
        // sb.append(" order by concat(seqid)");
        // System.out.println(sb);
    }
}
