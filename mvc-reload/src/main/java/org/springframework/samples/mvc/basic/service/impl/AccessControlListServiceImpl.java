package org.springframework.samples.mvc.basic.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.mvc.basic.model.AclEntry;
import org.springframework.samples.mvc.basic.service.AccessControlListService;
import org.springframework.stereotype.Component;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

@Component("acl.service.accessControlService")
public class AccessControlListServiceImpl implements AccessControlListService, ConfigurationListener {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "acl.config.aclExtConfig")
	private HierarchicalConfiguration config;

	private Predicate<AclEntry> aclEntryFilterPredicate = null;

	protected static String CONF_KEYN = "entryFilter";
	protected static String CONF_KEY_INCLUDED_PERMISSION = "entryFilter.includedPermission";
	protected static String CONF_KEY_EXCLUDED_FUNCTION = "entryFilter.excludedFunction";

	protected Predicate<AclEntry> getAclEntryFilterPredicate() {
		log.debug("getAclEntryFilterPredicate..");
		if (aclEntryFilterPredicate == null) {
			initAclEntryPredicate();

			if (this.config != null) {
				this.config.addConfigurationListener(this);
			}
		} else {
			if (config != null) {
				// dummy operation on config to trigger reload event
				config.getList(CONF_KEY_INCLUDED_PERMISSION);

//				log.debug("dummy operation on config to trigger reload event");
//				log.debug("includedPermission is {}", config.getList(CONF_KEY_INCLUDED_PERMISSION));

				// for (HierarchicalConfiguration strategyConfig :
				// (List<HierarchicalConfiguration>)
				// config.configurationsAt(CONF_KEYN)) {
				// log.debug("excludedFunction is {}",
				// strategyConfig.getList("excludedFunction"));
				// }
				//
				// // Iterator keys = subConfig.getKeys();
				// // while (keys.hasNext()) {
				// // Object next = keys.next();
				// // log.info("config is {} ", next);
				// // }
				//
				// // List subConfigList =
				// config.configurationsAt(CONF_KEY_INCLUDED_PERMISSION);
				// // log.info("config list is {} ", subConfigList);
				// // for(String key : config.getKeys()){
				// //
				// // }
			}
		}

		// log.debug(AclEntryFilterPredicate)
//		log.debug("aclEntryFilterPredicate is {}", aclEntryFilterPredicate.toString());

		return aclEntryFilterPredicate;
	}

	public void configurationChanged(ConfigurationEvent event) {
		log.debug("configurationChanged()..");
		log.debug("configurationChanged event {} ?", event.isBeforeUpdate());
		if (!event.isBeforeUpdate()) {
			initAclEntryPredicate();
			log.debug("isBeforeUpdate is false,and init..");
		}
	}

	public List<AclEntry> listAvailableEntries() {
		List<AclEntry> entries = new ArrayList<AclEntry>();// AclEntryDao.findAllByUserId(userId,
															// companyCode);

		return new ArrayList<AclEntry>(Collections2.filter(entries, this.getAclEntryFilterPredicate()));
	}

	public boolean isAccessible() {
		AclEntry aclEntry1 = new AclEntry(1L, "V", "FUN");// AclEntryDao.findAclEntryByUserId(functionId,
		// permissionCode, userId,
		// companyCode);

//		AclEntry aclEntry2 = new AclEntry(2L, "V", "FUNC1");
//		AclEntry aclEntry3 = new AclEntry(3L, "E", "FU");
//		AclEntry aclEntry4 = new AclEntry(4L, "E", "FUNC2");
//		log.debug("Result1 is {}", this.getAclEntryFilterPredicate().apply(aclEntry1));
//		log.debug("Result2 is {}", this.getAclEntryFilterPredicate().apply(aclEntry2));
//		log.debug("Result3 is {}", this.getAclEntryFilterPredicate().apply(aclEntry3));
//		log.debug("Result4 is {}", this.getAclEntryFilterPredicate().apply(aclEntry4));

		return (aclEntry1 != null && this.getAclEntryFilterPredicate().apply(aclEntry1));
	}

	/**
	 * Create AclEntry Filtering Predicate base on config
	 */
	protected void initAclEntryPredicate() {
		log.debug("initAclEntryPredicate...");
		List<Predicate<AclEntry>> predicates = new ArrayList<Predicate<AclEntry>>();

		if (this.config != null) {
			// read from config & create predicate
			String[] includedPermissions = config.getStringArray(CONF_KEY_INCLUDED_PERMISSION);
			if (includedPermissions != null && includedPermissions.length > 0) {
				predicates.add(new IncludedPermissionAclEntryPredicate(includedPermissions));
			}

			String[] excludedFunctions = config.getStringArray(CONF_KEY_EXCLUDED_FUNCTION);
			if (excludedFunctions != null && excludedFunctions.length > 0) {
				predicates.add(new ExcludedFunctionAclEntryPredicate(excludedFunctions));
			}
		}

		if (!predicates.isEmpty()) {
			this.aclEntryFilterPredicate = Predicates.and(predicates);
		} else {
			this.aclEntryFilterPredicate = Predicates.alwaysTrue();
		}
	}

	// /////////////////////////////////
	// Internally used inner classes
	// /////////////////////////////////

	protected static class IncludedPermissionAclEntryPredicate implements Predicate<AclEntry> {
		private Set<String> includedPermissions = new HashSet<String>();

		public IncludedPermissionAclEntryPredicate(String[] includedPermissions) {
			this.includedPermissions.addAll(Arrays.asList(includedPermissions));
		}

		public boolean apply(AclEntry AclEntry) {
			return this.includedPermissions.contains(AclEntry.getPermission());// .getCode()
		}

	}

	protected static class ExcludedFunctionAclEntryPredicate implements Predicate<AclEntry> {
		private Set<String> excludedFunctions = new HashSet<String>();

		public ExcludedFunctionAclEntryPredicate(String[] excludedFunctions) {
			this.excludedFunctions.addAll(Arrays.asList(excludedFunctions));
		}

		public boolean apply(AclEntry AclEntry) {
			return !this.excludedFunctions.contains(AclEntry.getFunction());// .getId()
		}

	}
}
