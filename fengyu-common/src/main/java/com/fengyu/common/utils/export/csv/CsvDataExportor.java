package com.fengyu.common.utils.export.csv;

import com.fengyu.common.utils.export.txt.TxtDataExportor;
import com.fengyu.common.utils.export.DataField;
import com.fengyu.common.utils.export.ExportDataSource;

import java.io.OutputStream;


/**
 * 描述: csv格式数据导出工具
 * @author Hill
 *
 */
public class CsvDataExportor<T> extends TxtDataExportor<T> {
	public CsvDataExportor(DataField[] fields, ExportDataSource<T> dataSource,OutputStream os) {
		super(fields, dataSource, os,",");
	}
}
