package com.bookstore.utils;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import com.bookstore.entities.BaseObject;

public class CustomIDGenerator implements IdentifierGenerator, Configurable{
	private String sequenceCallSyntax;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		 final JdbcEnvironment jdbcEnvironment = serviceRegistry.getService(JdbcEnvironment.class);
	        final Dialect dialect = jdbcEnvironment.getDialect();

	        final String sequencePerEntitySuffix = ConfigurationHelper.getString(SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, params, SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX);

	        final String defaultSequenceName = ConfigurationHelper.getBoolean(SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, params, false)
	                ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
	                : SequenceStyleGenerator.DEF_SEQUENCE_NAME;

	        sequenceCallSyntax = dialect.getSequenceNextValString(ConfigurationHelper.getString(SequenceStyleGenerator.SEQUENCE_PARAM, params, defaultSequenceName));
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (obj instanceof BaseObject) {
            BaseObject baseObject = (BaseObject) obj;
            Serializable id = baseObject.getId();
            if (id != null) {
                return id;
            }
        }
        
		String seqValue = ((Number) Session.class.cast(session)
                .createNativeQuery(sequenceCallSyntax)
                .uniqueResult()).toString();
        
        String idString = obj.getClass().getSimpleName().substring(0, 1) + "0000";

        return idString.substring(0, (idString.length() - seqValue.length())) + seqValue;
		
	}




}
