package com.freetmp.mbg.plugin

import org.junit.Rule
import org.junit.contrib.java.lang.system.SystemOutRule
import org.mybatis.generator.api.IntrospectedColumn
import org.mybatis.generator.api.IntrospectedTable
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType
import org.mybatis.generator.api.dom.java.Interface
import org.mybatis.generator.api.dom.java.TopLevelClass
import org.mybatis.generator.api.dom.xml.Document
import org.mybatis.generator.api.dom.xml.XmlElement
import org.mybatis.generator.config.TableConfiguration
import org.mybatis.generator.internal.rules.Rules
import spock.lang.Specification

/**
 * Created by LiuPin on 2015/5/20.
 */
abstract class AbstractPluginSpec extends Specification {

  @Rule SystemOutRule systemOutRule = new SystemOutRule().muteForSuccessfulTests()

  Interface interfaze = Spy(Interface, constructorArgs: [User.class.canonicalName + "Mapper"])
  TopLevelClass topLevelClass = Mock()

  Document document = Spy() {
    document.getRootElement() >> root
  }
  XmlElement root = Spy(XmlElement, constructorArgs: ["mapper"])

  Rules rules = Stub() {
    rules.calculateAllFieldsClass() >> new FullyQualifiedJavaType(User.class.canonicalName)
  }

  TableConfiguration tableConfiguration = Stub() {
    tableConfiguration.getDomainObjectName() >> User.class.simpleName
  }

  IntrospectedTable introspectedTable = Stub() {
    introspectedTable.getRules() >> rules
    introspectedTable.getTableConfiguration() >> tableConfiguration
    introspectedTable.getAllColumns() >> introspectedColumns
    introspectedTable.getPrimaryKeyColumns() >> introspectedPkColumns
    introspectedTable.getNonPrimaryKeyColumns() >> introspectedNpkColumns
    introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime() >> "user"
  }

  List<IntrospectedColumn> introspectedColumns = [
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "id" }; getJavaProperty() >> "id"; getJdbcTypeName() >> "BIGINT"; getActualColumnName() >> "id"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "loginName" }; getJavaProperty() >> "loginName"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "login_Name"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "name" }; getJavaProperty() >> "name"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "name"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "password" }; getJavaProperty() >> "password"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "password"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "salt" }; getJavaProperty() >> "salt"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "salt"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "roles" }; getJavaProperty() >> "roles"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "roles"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "registerDate" }; getJavaProperty() >> "registerDate"; getJdbcTypeName() >> "TIMESTAMP"; getActualColumnName() >> "register_date"; isColumnNameDelimited() >> false }
  ]

  List<IntrospectedColumn> introspectedNpkColumns = [
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "loginName" }; getJavaProperty() >> "loginName"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "login_Name"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "name" }; getJavaProperty() >> "name"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "name"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "password" }; getJavaProperty() >> "password"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "password"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "salt" }; getJavaProperty() >> "salt"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "salt"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "roles" }; getJavaProperty() >> "roles"; getJdbcTypeName() >> "VARCHAR"; getActualColumnName() >> "roles"; isColumnNameDelimited() >> false },
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "registerDate" }; getJavaProperty() >> "registerDate"; getJdbcTypeName() >> "TIMESTAMP"; getActualColumnName() >> "register_date"; isColumnNameDelimited() >> false }
  ]

  List<IntrospectedColumn> introspectedPkColumns = [
      Mock(IntrospectedColumn) { getJavaProperty(_) >> { String prefix -> prefix + "id" }; getJavaProperty() >> "id"; getJdbcTypeName() >> "BIGINT"; getActualColumnName() >> "id"; isColumnNameDelimited() >> false },
  ]

}